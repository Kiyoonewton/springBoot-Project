package Kiyoonewton.demo.job.implement;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import Kiyoonewton.demo.job.Job;

public interface JobRepository extends JpaRepository<Job, UUID> {

}
