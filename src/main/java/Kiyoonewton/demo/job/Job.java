package Kiyoonewton.demo.job;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import Kiyoonewton.demo.company.Company;

@Entity
public class Job {
    @Id
    @GeneratedValue(generator = "UUID") // Use UUID generator
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Job() {
    }

    public Job(String title, String description, String minSalary, String maxSalary,
            String location) {
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

@ManyToOne
@JoinColumn(name = "company_id")
private Company company;

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getLocation() {
        return location;
    }

}
