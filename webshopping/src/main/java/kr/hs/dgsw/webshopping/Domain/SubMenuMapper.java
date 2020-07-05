package kr.hs.dgsw.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubMenuMapper {
    List<SubMenu> findByMenuId(Long menuId);
    SubMenu findById(Long id);
    
}