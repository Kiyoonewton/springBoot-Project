package Kiyoonewton.demo.review;

import java.util.List;
import Kiyoonewton.demo.company.Company;

public interface ReviewService {
    List<Review> getAllReviews(Company CompanyId);

}