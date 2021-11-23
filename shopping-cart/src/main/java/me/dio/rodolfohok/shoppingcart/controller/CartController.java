package me.dio.rodolfohok.shoppingcart.controller;

import me.dio.rodolfohok.shoppingcart.model.Cart;
import me.dio.rodolfohok.shoppingcart.model.Item;
import me.dio.rodolfohok.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

  private CartRepository cartRepository;

  @Autowired
  public CartController(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @PostMapping("/{id}")
  public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
    Optional<Cart> savedCart = cartRepository.findById(id);
    Cart cart = savedCart.orElseGet(() -> new Cart(id));
    cart.getItems().add(item);
    return cartRepository.save(cart);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cart> findById(@PathVariable("id") Integer id) {
    Optional<Cart> cart = cartRepository.findById(id);
    return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public void clear(@PathVariable("id") Integer id) {
    cartRepository.deleteById(id);
  }
}
