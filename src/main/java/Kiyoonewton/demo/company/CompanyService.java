package Kiyoonewton.demo.company;

import java.util.*;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(UUID id, Company updateCompany);

    void createCompany(Company company);

    Company getCompanyById(UUID id);

    boolean deleteCompanyById(UUID id);
}
