package Kiyoonewton.demo.review;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByCompanyId(UUID companyId);
}
