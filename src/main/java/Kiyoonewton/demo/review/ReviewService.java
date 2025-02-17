package Kiyoonewton.demo.review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<Review> getAllReviews(UUID companyId);
    boolean createReview(UUID companyId, Review review);

}