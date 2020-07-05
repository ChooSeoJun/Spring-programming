package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshopping.Domain.Product;
import kr.hs.dgsw.webshopping.Domain.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;

	@Override
	public Long add(Product product) {
		return productMapper.add(product);
	}

	@Override
	public int modify(Product product) {
		return productMapper.modify(product);
	}

	@Override
	public int deleteById(Long id) {
		return productMapper.deleteById(id);
	}

	@Override
	public Product findById(Long id) {
		return productMapper.findById(id);
	}

	@Override
	public List<Product> findByMenuId(Long menuId) {
		return productMapper.findByMenuId(menuId);
	}

	@Override
	public List<Product> findBySubMenuId(Long submenuId) {
		return productMapper.findBySubMenuId(submenuId);
	}

	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}
}