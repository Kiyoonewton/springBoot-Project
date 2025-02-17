package Kiyoonewton.demo.review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<Review> getAllReviews(UUID companyId);
    boolean createReview(UUID companyId, Review review);
    Review getReview(UUID companyId, UUID reviewId);
    boolean updateReview(UUID companyId, UUID reviewId, Review review);
    boolean deleteReview(UUID companyId, UUID reviewId);
}