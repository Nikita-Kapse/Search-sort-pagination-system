package util;

import model.Record;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Record> generateRecords() {

        List<Record> records = new ArrayList<>();

        records.add(new Record(1, "Laptop Sales Report", "Sales",
                LocalDate.of(2026, 8, 1), 50000));

        records.add(new Record(2, "Mobile Sales Report", "Sales",
                LocalDate.of(2026, 8, 2), 30000));

        records.add(new Record(3, "Monthly HR Report", "HR",
                LocalDate.of(2026, 8, 3), 15000));

        records.add(new Record(4, "Inventory Update", "Inventory",
                LocalDate.of(2026, 8, 4), 25000));

        records.add(new Record(5, "Electronics Sales", "Sales",
                LocalDate.of(2026, 8, 5), 70000));

        records.add(new Record(6, "Customer Report", "Customer",
                LocalDate.of(2026, 8, 6), 18000));

        records.add(new Record(7, "Warehouse Stock", "Inventory",
                LocalDate.of(2026, 8, 7), 45000));

        records.add(new Record(8, "Sales Performance", "Sales",
                LocalDate.of(2026, 8, 8), 65000));

        records.add(new Record(9, "Employee Report", "HR",
                LocalDate.of(2026, 8, 9), 22000));

        records.add(new Record(10, "Product Sales Data", "Sales",
                LocalDate.of(2026, 8, 10), 55000));

        records.add(new Record(11, "Customer Feedback", "Customer",
                LocalDate.of(2026, 8, 11), 12000));

        records.add(new Record(12, "Inventory Check", "Inventory",
                LocalDate.of(2026, 8, 12), 35000));

        records.add(new Record(13, "Laptop Inventory", "Inventory",
                LocalDate.of(2026, 8, 13), 48000));

        records.add(new Record(14, "Quarterly Sales", "Sales",
                LocalDate.of(2026, 8, 14), 90000));

        records.add(new Record(15, "HR Attendance", "HR",
                LocalDate.of(2026, 8, 15), 10000));

        records.add(new Record(16, "Mobile Inventory", "Inventory",
                LocalDate.of(2026, 8, 16), 42000));

        records.add(new Record(17, "Customer Sales Analysis", "Sales",
                LocalDate.of(2026, 8, 17), 60000));

        records.add(new Record(18, "Employee Performance", "HR",
                LocalDate.of(2026, 8, 18), 28000));

        records.add(new Record(19, "Sales Target Report", "Sales",
                LocalDate.of(2026, 8, 19), 75000));

        records.add(new Record(20, "Product Inventory Report", "Inventory",
                LocalDate.of(2026, 8, 20), 38000));

        records.add(new Record(21, "Daily Sales Report", "Sales",
                LocalDate.of(2026, 8, 21), 52000));

        records.add(new Record(22, "Customer Orders", "Customer",
                LocalDate.of(2026, 8, 22), 47000));

        records.add(new Record(23, "Annual Sales Summary", "Sales",
                LocalDate.of(2026, 8, 23), 120000));

        records.add(new Record(24, "Stock Availability", "Inventory",
                LocalDate.of(2026, 8, 24), 33000));

        records.add(new Record(25, "Sales Forecast", "Sales",
                LocalDate.of(2026, 8, 25), 85000));

        return records;
    }
}