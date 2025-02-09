package Kiyoonewton.demo.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import Kiyoonewton.demo.job.Job;
import java.util.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String title;
    private String description;

    public Company(UUID id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @OneToMany
    private List<Job> jobs;

    public Company() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
