package Kiyoonewton.demo.review;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import Kiyoonewton.demo.company.Company;

@Entity
public class Review {

    private UUID id;
    private String title;
    private String description;
    private double rating;

    @ManyToOne
    private Company company;

    public Review(UUID id, String title, String description, double rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public Review() {}

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
