package Kiyoonewton.demo.review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Kiyoonewton.demo.company.CompanyService;

@RestController
@RequestMapping("/company/{companyId}/reviews")
public class ReviewController {
    private CompanyService companyService;

    public ReviewController(CompanyService companyService) {
        this.companyService = companyService;
    }

    
}