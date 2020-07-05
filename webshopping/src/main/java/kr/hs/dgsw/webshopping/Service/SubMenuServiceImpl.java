package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshopping.Domain.SubMenu;
import kr.hs.dgsw.webshopping.Domain.SubMenuMapper;

@Service
public class SubMenuServiceImpl implements SubMenuService{
    @Autowired
    SubMenuMapper subMenuMapper;

	@Override
	public List<SubMenu> findByMenuId(Long menuId) {
		return subMenuMapper.findByMenuId(menuId);
	}

	@Override
	public SubMenu findById(Long id) {
		return subMenuMapper.findById(id);
	}


}