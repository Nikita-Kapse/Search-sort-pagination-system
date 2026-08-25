package service;

import model.Record;

import java.util.ArrayList;
import java.util.List;

public class PaginationService {

    public List<Record> getPage(
            List<Record> records,
            int pageNumber,
            int pageSize) {

        if (records == null || records.isEmpty()) {
            return new ArrayList<>();
        }

        if (pageNumber <= 0) {
            throw new IllegalArgumentException(
                    "Page number must be greater than 0."
            );
        }

        if (pageSize <= 0) {
            throw new IllegalArgumentException(
                    "Page size must be greater than 0."
            );
        }

        int startIndex = (pageNumber - 1) * pageSize;

        if (startIndex >= records.size()) {
            return new ArrayList<>();
        }

        int endIndex = Math.min(
                startIndex + pageSize,
                records.size()
        );

        return new ArrayList<>(
                records.subList(startIndex, endIndex)
        );
    }

    public int getTotalPages(
            List<Record> records,
            int pageSize) {

        if (records == null || records.isEmpty()) {
            return 0;
        }

        if (pageSize <= 0) {
            throw new IllegalArgumentException(
                    "Page size must be greater than 0."
            );
        }

        return (int) Math.ceil(
                (double) records.size() / pageSize
        );
    }
}