package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshopping.Domain.Cart;
import kr.hs.dgsw.webshopping.Domain.CartMapper;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartMapper cartMapper;

	@Override
	public Long add(Cart cart) {
		return cartMapper.add(cart);
	}

	@Override
	public int deleteById(Long id) {
		return cartMapper.deleteById(id);
	}

	@Override
	public int deleteByUserId(Long userId) {
        return cartMapper.deleteByUserId(userId);
	}

	@Override
	public Cart findById(Long id) {
		return cartMapper.findById(id);
	}

	@Override
	public List<Cart> findByUserId(Long userId) {
		return cartMapper.findByUserId(userId);
	}   

	@Override
    public int modify(Cart cart) {
        return cartMapper.modify(cart);
	}

	@Override
	public void deleteAll() {
		cartMapper.deleteAll();	
	}
	
	
}