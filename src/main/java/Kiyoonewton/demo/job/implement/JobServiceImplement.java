package Kiyoonewton.demo.job.implement;

import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.springframework.stereotype.Service;
import Kiyoonewton.demo.job.Job;
import Kiyoonewton.demo.job.JobRepository;
import Kiyoonewton.demo.job.JobService;

@Service
public class JobServiceImplement implements JobService {

    JobRepository jobRepository;

    public JobServiceImplement(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(UUID id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(UUID Id) {
        try {
            jobRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(UUID id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean patchJob(UUID id, Job patchedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            if (patchedJob.getTitle() != null)
                job.setTitle(patchedJob.getTitle());
            if (patchedJob.getDescription() != null)
                job.setDescription(patchedJob.getDescription());
            if (patchedJob.getMinSalary() != null)
                job.setMinSalary(patchedJob.getMinSalary());
            if (patchedJob.getMaxSalary() != null)
                job.setMaxSalary(patchedJob.getMaxSalary());
            if (patchedJob.getLocation() != null)
                job.setLocation(patchedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
