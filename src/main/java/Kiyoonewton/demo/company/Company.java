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
    private String name;
    private String description;

    public Company(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
