package org.rahmasir.elasticsearchwithspringboot.repository;

import org.rahmasir.elasticsearchwithspringboot.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"name\", \"description\"]}}")
    List<Product> findByQuery(String query);

    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"name\", \"description\"], \"fuzziness\": \"AUTO\"}}")
    List<Product> findByQueryWithFuzziness(String query);
}
