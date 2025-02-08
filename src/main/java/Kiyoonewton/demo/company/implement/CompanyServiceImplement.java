package Kiyoonewton.demo.company.implement;

import java.util.List;
import org.springframework.stereotype.Service;
import Kiyoonewton.demo.company.*;

@Service
public class CompanyServiceImplement implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplement(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyServiceImplement() {}

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
