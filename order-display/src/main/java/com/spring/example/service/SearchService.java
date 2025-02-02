package com.spring.example.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.spring.example.util.ElasticSearchUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService<T> {

    private final ElasticsearchClient elasticsearchClient;

    public List<T> searchCustomerByFieldValue(String key, String value, String documentName ,Class<T> tClass) throws IOException {
        Supplier<Query> querySupplier = ElasticSearchUtil.buildQueryForFieldAndValue(key, value);
        SearchResponse<T> response = elasticsearchClient
                .search(s -> s.index(documentName).query(querySupplier.get()), tClass);
        return extractItemsFromResponse(response);
    }

    public List<T> extractItemsFromResponse(SearchResponse<T> response) {
        return response
                .hits()
                .hits()
                .stream()
                .map(Hit::source)
                .collect(Collectors.toList());
    }
}
