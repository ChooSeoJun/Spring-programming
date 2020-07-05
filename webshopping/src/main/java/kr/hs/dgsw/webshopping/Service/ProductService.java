package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import kr.hs.dgsw.webshopping.Domain.Product;

public interface ProductService {
    Long add(Product product);
    int modify(Product product);
    int deleteById(Long id);
    Product findById(Long id);
    List<Product> findByMenuId(Long menuId);
    List<Product> findBySubMenuId(Long submenuId);
    List<Product> findAll();
}