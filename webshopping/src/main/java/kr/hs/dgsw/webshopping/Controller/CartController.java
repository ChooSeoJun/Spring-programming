package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.Cart;
import kr.hs.dgsw.webshopping.Service.CartService;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(value = "/api/cart")
    public Long add(@RequestBody Cart cart){
        return cartService.add(cart);
    }

    @GetMapping(value = "/api/cart/{id}")
    public Cart findById(@PathVariable Long id){
        return cartService.findById(id);
    }

    @GetMapping(value = "/api/cart/user/{userId}")
    public List<Cart> findByUserId(@PathVariable Long userId){
        return cartService.findByUserId(userId);
    }

    @DeleteMapping(value = "/api/cart/{id}")
    public int deleteById(@PathVariable Long id){
        return cartService.deleteById(id);
    }

    @DeleteMapping(value = "/api/cart/user/userId")
    public int deleteByUserId(@Param("userId") Long userId){
        return cartService.deleteById(userId);
    }

    @PutMapping(value="/api/cart")
    public int updateById(@RequestBody Cart cart) {
        return cartService.modify(cart);
    }

    @DeleteMapping(value="/api/cart/deleteAll")
    public void deleteAll(){
        cartService.deleteAll();
    }
}