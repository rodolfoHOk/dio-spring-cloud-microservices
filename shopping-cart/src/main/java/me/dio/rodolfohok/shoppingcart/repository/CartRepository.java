package me.dio.rodolfohok.shoppingcart.repository;

import me.dio.rodolfohok.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
