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
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(UUID id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompany(UUID id, Company updateCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            if (updateCompany.getName() != null)
                company.setName(updateCompany.getName());
            if (updateCompany.getDescription() != null)
                company.setDescription(updateCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(UUID id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
