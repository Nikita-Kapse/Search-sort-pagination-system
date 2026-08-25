package service;

import model.Record;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortService {

    public List<Record> sortRecords(
            List<Record> records,
            String sortField,
            boolean ascending) {

        List<Record> sortedRecords = new ArrayList<>(records);

        Comparator<Record> comparator;

        switch (sortField.toLowerCase()) {

            case "name":
                comparator = Comparator.comparing(
                        Record::getName,
                        String.CASE_INSENSITIVE_ORDER
                );
                break;

            case "date":
                comparator = Comparator.comparing(Record::getDate);
                break;

            case "value":
                comparator = Comparator.comparingDouble(Record::getValue);
                break;

            default:
                System.out.println("Invalid sort field.");
                return sortedRecords;
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        sortedRecords.sort(comparator);

        return sortedRecords;
    }
}