package Kiyoonewton.demo.job;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(UUID id);
    boolean deleteJobById(UUID id);
    boolean updateJob(UUID id, Job updatedJob);
    boolean patchJob(UUID id, Job patchedJob);
}
