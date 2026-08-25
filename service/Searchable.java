package service;

import model.Record;
import java.util.List;

public interface Searchable {
    List<Record> search(String keyword);
}
