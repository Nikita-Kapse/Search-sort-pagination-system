package thread;

import model.Record;
import service.SearchService;
import service.Searchable;
import service.SortService;

import java.util.List;
import java.util.concurrent.Callable;

public class SearchSortTask implements Callable<List<Record>> {

    private final List<Record> records;
    private final String keyword;
    private final String sortField;
    private final boolean ascending;

    public SearchSortTask(
            List<Record> records,
            String keyword,
            String sortField,
            boolean ascending) {

        this.records = records;
        this.keyword = keyword;
        this.sortField = sortField;
        this.ascending = ascending;
    }

    @Override
    public List<Record> call() {

        System.out.println(
                "\n[Worker Thread] Starting search and sorting..."
        );

        // Search operation
        Searchable searchService =
                new SearchService(records);

        List<Record> searchResults =
                searchService.search(keyword);

        // Sort operation
        SortService sortService =
                new SortService();

        List<Record> sortedResults =
                sortService.sortRecords(
                        searchResults,
                        sortField,
                        ascending
                );

        System.out.println(
                "[Worker Thread] Search and sorting completed."
        );

        return sortedResults;
    }
}