package kr.hs.dgsw.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.webshopping.Domain.Product;
import kr.hs.dgsw.webshopping.Service.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/api/product/id")
    public Product findById(@Param("id") Long id){
        return productService.findById(id);
    }

    @GetMapping(value = "/api/product/menuId")
    public List<Product> findByMenuId(@Param("menuId") Long menuId){
        return productService.findByMenuId(menuId);
    }

    @GetMapping(value = "/api/product/submenuId")
    public List<Product> findBySubMenuId(@Param("submenuId") Long submenuId){
        return productService.findBySubMenuId(submenuId);
    }

    @GetMapping(value = "/api/product")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping(value = "/api/product")
    public Long add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping(value = "/api/product")
    public int modify(@RequestBody Product product){
        return productService.modify(product);
    }

    @DeleteMapping(value = "/api/product")
    public int deleteById(@Param("id") Long id){
        return productService.deleteById(id);
    }
}