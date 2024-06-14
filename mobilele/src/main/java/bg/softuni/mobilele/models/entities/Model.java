package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model extends BaseEntity{

    private String name;
    private Category category;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;
    @OneToOne(mappedBy = "model")
    private Offer offer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
