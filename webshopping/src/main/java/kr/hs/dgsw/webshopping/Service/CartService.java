package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import kr.hs.dgsw.webshopping.Domain.Cart;

public interface CartService {
    Long add(Cart cart);
    int deleteById(Long id);
    int deleteByUserId(Long userId);
    Cart findById(Long id);
    List<Cart> findByUserId(Long userId);
    int modify(Cart cart);
    void deleteAll();
}