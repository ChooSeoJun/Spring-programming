package kr.hs.dgsw.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    Long add(Product product);
    int modify(Product product);
    int deleteById(@Param("id") Long id);
    Product findById(@Param("id") Long id);
    List<Product> findByMenuId(@Param("menuId") Long menuId); // 상위 카테고리에 해당되는 모든 Product 반환
    List<Product> findBySubMenuId(@Param("submenuId") Long submenuId); // 서브 카테고리에 해당되는 모든 Product 반환
    List<Product> findAll();
}