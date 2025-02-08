package Kiyoonewton.demo.company;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}