package org.rahmasir.elasticsearchwithspringboot.repository;

import org.rahmasir.elasticsearchwithspringboot.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
