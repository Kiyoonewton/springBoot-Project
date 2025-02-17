package Kiyoonewton.demo.review.implement;

import java.util.*;
import org.springframework.stereotype.Service;
import Kiyoonewton.demo.company.Company;
import Kiyoonewton.demo.company.CompanyService;
import Kiyoonewton.demo.review.*;

@Service
public class ReviewServiceImplement implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImplement(ReviewRepository reviewRepository,
            CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(UUID companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(UUID companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Review getReview(UUID companyId, UUID reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(UUID companyId, UUID reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
            Optional<Review> optional = reviewRepository.findById(reviewId);
            if (optional.isPresent()) {
                Review review = optional.get();
                if (updatedReview.getTitle() != null) {
                    review.setTitle(updatedReview.getTitle());
                }
                if(updatedReview.getDescription() != null){
                    review.setDescription(updatedReview.getDescription());
                }
                if(updatedReview.getRating() != null){
                    review.setRating(updatedReview.getRating());
                }
                reviewRepository.save(review);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(UUID companyId, UUID reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
