package Kiyoonewton.demo.review.implement;

import java.util.*;
import org.springframework.stereotype.Service;
import Kiyoonewton.demo.company.Company;
import Kiyoonewton.demo.company.CompanyService;
import Kiyoonewton.demo.review.*;

@Service
public class ReviewServiceImplement implements ReviewService{
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImplement(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(UUID companyId){
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(UUID companyId, Review review){
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }
}