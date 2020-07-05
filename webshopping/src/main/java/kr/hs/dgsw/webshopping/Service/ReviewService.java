package kr.hs.dgsw.webshopping.Service;

import java.util.List;

import kr.hs.dgsw.webshopping.Domain.Review;

public interface ReviewService {
    Long add(Review review);
    int deleteById(Long id);
    int modify(Review review);
    List<Review> findByProductId(Long productId);
}