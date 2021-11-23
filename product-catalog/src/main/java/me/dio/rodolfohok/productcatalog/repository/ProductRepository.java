package me.dio.rodolfohok.productcatalog.repository;

import me.dio.rodolfohok.productcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
