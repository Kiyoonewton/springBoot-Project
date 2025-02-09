package Kiyoonewton.demo.company.implement;

import java.util.*;
import org.springframework.stereotype.Service;
import Kiyoonewton.demo.company.*;

@Service
public class CompanyServiceImplement implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplement(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(UUID id, Company updateCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            if (updateCompany.getTitle() != null)
                company.setTitle(updateCompany.getTitle());
            if (updateCompany.getDescription() != null)
                company.setDescription(updateCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }
}
