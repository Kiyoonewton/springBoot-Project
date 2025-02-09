package Kiyoonewton.demo.company;

import java.util.*;
public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(UUID id,Company updateCompany);
}