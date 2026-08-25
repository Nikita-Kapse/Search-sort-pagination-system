package main;

import model.Record;
import service.PaginationService;
import thread.SearchSortTask;
import util.DataGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Generate dataset once
        List<Record> records = DataGenerator.generateRecords();

        // Create pagination service
        PaginationService paginationService = new PaginationService();

        // Create thread pool once
        ExecutorService executor = Executors.newFixedThreadPool(2);

        boolean running = true;

        System.out.println("==============================================");
        System.out.println("      SEARCH, SORT & PAGINATION SYSTEM");
        System.out.println("==============================================");

        while (running) {

            showMenu();

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    performSearch(
                            records,
                            paginationService,
                            executor
                    );
                    break;

                case 2:
                    displayAllRecords(records);
                    break;

                case 3:
                    running = false;
                    System.out.println("\nThank you for using the application!");
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }

        // Shutdown thread pool
        executor.shutdown();

        // Close scanner
        scanner.close();
    }

    // ================= MENU =================

    private static void showMenu() {

        System.out.println("\n--------------- MENU ---------------");

        System.out.println("1. Search, Sort and Paginate Records");
        System.out.println("2. View All Records");
        System.out.println("3. Exit");

        System.out.println("------------------------------------");
    }

    // ================= MAIN OPERATION =================

    private static void performSearch(
            List<Record> records,
            PaginationService paginationService,
            ExecutorService executor) {

        try {

            System.out.println(
                    "\n======= SEARCH & SORT OPERATION ======="
            );

            // SEARCH KEYWORD
            System.out.print("Enter search keyword: ");
            String keyword = scanner.nextLine();

            // SORT FIELD
            System.out.println("\nChoose Sort Field:");
            System.out.println("1. Name");
            System.out.println("2. Date");
            System.out.println("3. Value");

            int sortChoice =
                    getIntInput("Enter choice: ");

            String sortField;

            switch (sortChoice) {

                case 1:
                    sortField = "name";
                    break;

                case 2:
                    sortField = "date";
                    break;

                case 3:
                    sortField = "value";
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Defaulting to Name."
                    );
                    sortField = "name";
            }

            // SORT ORDER
            System.out.println("\nChoose Sort Order:");
            System.out.println("1. Ascending");
            System.out.println("2. Descending");

            int orderChoice =
                    getIntInput("Enter choice: ");

            boolean ascending = orderChoice == 1;

            // ================= MULTITHREADING =================

            SearchSortTask task =
                    new SearchSortTask(
                            records,
                            keyword,
                            sortField,
                            ascending
                    );

            Future<List<Record>> future =
                    executor.submit(task);

            System.out.println(
                    "\n[Main Thread] Task submitted to worker thread..."
            );

            // Receive result from worker thread
            List<Record> sortedResults = future.get();

            if (sortedResults.isEmpty()) {

                System.out.println(
                        "\nNo records found for your search."
                );

                return;
            }

            System.out.println(
                    "\nRecords Found: " + sortedResults.size()
            );

            // ================= PAGINATION =================

            int pageSize;

            do {

                pageSize =
                        getIntInput(
                                "Enter page size: "
                        );

                if (pageSize <= 0) {

                    System.out.println(
                            "Page size must be greater than 0."
                    );
                }

            } while (pageSize <= 0);

            int totalPages =
                    paginationService.getTotalPages(
                            sortedResults,
                            pageSize
                    );

            System.out.println(
                    "Total Pages Available: " + totalPages
            );

            int pageNumber;

            do {

                pageNumber =
                        getIntInput(
                                "Enter page number: "
                        );

                if (pageNumber < 1 ||
                        pageNumber > totalPages) {

                    System.out.println(
                            "Invalid page number. Enter between 1 and "
                                    + totalPages
                    );
                }

            } while (pageNumber < 1 ||
                    pageNumber > totalPages);

            List<Record> paginatedResults =
                    paginationService.getPage(
                            sortedResults,
                            pageNumber,
                            pageSize
                    );

            // ================= DISPLAY =================

            displayResults(
                    paginatedResults,
                    keyword,
                    sortField,
                    ascending,
                    pageNumber,
                    totalPages
            );

        } catch (Exception e) {

            System.out.println(
                    "\nError while processing request: "
                            + e.getMessage()
            );
        }
    }

    // ================= DISPLAY RESULTS =================

    private static void displayResults(
            List<Record> results,
            String keyword,
            String sortField,
            boolean ascending,
            int pageNumber,
            int totalPages) {

        System.out.println("\n==============================================");
        System.out.println("              FINAL RESULTS");
        System.out.println("==============================================");

        System.out.println("Search Keyword : " + keyword);

        System.out.println("Sort Field     : " + sortField);

        System.out.println(
                "Sort Order     : " +
                        (ascending
                                ? "Ascending"
                                : "Descending")
        );

        System.out.println(
                "Page           : "
                        + pageNumber
                        + " of "
                        + totalPages
        );

        System.out.println("----------------------------------------------");

        for (Record record : results) {

            System.out.println(record);
        }

        System.out.println("----------------------------------------------");
    }

    // ================= VIEW ALL RECORDS =================

    private static void displayAllRecords(
            List<Record> records) {

        System.out.println(
                "\n============== ALL RECORDS =============="
        );

        for (Record record : records) {

            System.out.println(record);
        }

        System.out.println(
                "\nTotal Records: " + records.size()
        );
    }

    // ================= INPUT VALIDATION =================

    private static int getIntInput(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input = scanner.nextLine();

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}