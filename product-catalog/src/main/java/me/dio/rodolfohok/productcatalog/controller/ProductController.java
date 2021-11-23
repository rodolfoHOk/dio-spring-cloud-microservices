package me.dio.rodolfohok.productcatalog.controller;

import me.dio.rodolfohok.productcatalog.model.Product;
import me.dio.rodolfohok.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

  private ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody Product product){
    return productRepository.save(product);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id){
    Optional<Product> product = productRepository.findById(id);
    return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
