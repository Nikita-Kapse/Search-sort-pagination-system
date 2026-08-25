package service;

import model.Record;

import java.util.ArrayList;
import java.util.List;

public class SearchService implements Searchable {

    private List<Record> records;

    public SearchService(List<Record> records) {
        this.records = records;
    }

    @Override
    public List<Record> search(String keyword) {
        List<Record> results = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            return results;
        }

        String lowerKeyword = keyword.trim().toLowerCase();

        for (Record record : records) {
            if (record.getName().toLowerCase().contains(lowerKeyword) ||
                record.getCategory().toLowerCase().contains(lowerKeyword)) {
                results.add(record);
            }
        }

        return results;
    }
}
