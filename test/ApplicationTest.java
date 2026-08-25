package test;

import model.Record;
import service.PaginationService;
import service.SearchService;
import service.Searchable;
import service.SortService;
import util.DataGenerator;

import java.util.List;

public class ApplicationTest {

    public static void main(String[] args) {

        testSearch();
        testEmptySearch();
        testSorting();
        testPagination();
        testInvalidPagination();

        System.out.println("\n=================================");
        System.out.println("ALL TESTS PASSED SUCCESSFULLY!");
        System.out.println("=================================");
    }

    private static void testSearch() {

        List<Record> records =
                DataGenerator.generateRecords();

        Searchable searchService =
                new SearchService(records);

        List<Record> results =
                searchService.search("sales");

        if (results.isEmpty()) {
            throw new AssertionError(
                    "Search test failed: No sales records found."
            );
        }

        System.out.println("✓ Search test passed");
    }

    private static void testEmptySearch() {

        List<Record> records =
                DataGenerator.generateRecords();

        Searchable searchService =
                new SearchService(records);

        List<Record> results =
                searchService.search("");

        if (results.size() != records.size()) {
            throw new AssertionError(
                    "Empty search test failed."
            );
        }

        System.out.println("✓ Empty search test passed");
    }

    private static void testSorting() {

        List<Record> records =
                DataGenerator.generateRecords();

        SortService sortService =
                new SortService();

        List<Record> sortedRecords =
                sortService.sortRecords(
                        records,
                        "value",
                        true
                );

        for (int i = 0;
             i < sortedRecords.size() - 1;
             i++) {

            if (sortedRecords.get(i).getValue()
                    > sortedRecords.get(i + 1).getValue()) {

                throw new AssertionError(
                        "Sorting test failed."
                );
            }
        }

        System.out.println("✓ Sorting test passed");
    }

    private static void testPagination() {

        List<Record> records =
                DataGenerator.generateRecords();

        PaginationService paginationService =
                new PaginationService();

        List<Record> page =
                paginationService.getPage(
                        records,
                        2,
                        5
                );

        if (page.size() != 5) {
            throw new AssertionError(
                    "Pagination test failed."
            );
        }

        System.out.println("✓ Pagination test passed");
    }

    private static void testInvalidPagination() {

        List<Record> records =
                DataGenerator.generateRecords();

        PaginationService paginationService =
                new PaginationService();

        try {

            paginationService.getPage(
                    records,
                    1,
                    0
            );

            throw new AssertionError(
                    "Invalid pagination test failed."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "✓ Invalid pagination test passed"
            );
        }
    }
}