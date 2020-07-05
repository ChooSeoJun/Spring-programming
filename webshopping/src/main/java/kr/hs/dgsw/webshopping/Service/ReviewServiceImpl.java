package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.webshopping.Domain.Review;
import kr.hs.dgsw.webshopping.Domain.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewMapper reviewMapper;

	@Override
	public Long add(Review review) {
		return reviewMapper.add(review);
	}

	@Override
	public int deleteById(Long id) {
		return reviewMapper.deleteById(id);
	}

	@Override
	public int modify(Review review) {
		return reviewMapper.modify(review);
	}

	@Override
	public List<Review> findByProductId(Long productId) {
		return reviewMapper.findByProductId(productId);
	}
    
}