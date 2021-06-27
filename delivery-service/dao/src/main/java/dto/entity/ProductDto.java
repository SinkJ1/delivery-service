package dto.entity;

import java.util.List;
import java.util.Objects;

public class ProductDto {

    private Long id;
    private String name;
    private String producingCountry;
    private int yearOfIssue;
    private List<Long> categories;

    public ProductDto() {

    }

    public ProductDto(Long id, String name, String producingCountry, int yearOfIssue, List<Long> categories) {
        this.id = id;
        this.name = name;
        this.producingCountry = producingCountry;
        this.yearOfIssue = yearOfIssue;
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return yearOfIssue == that.yearOfIssue &&
                id.equals(that.id) &&
                name.equals(that.name) &&
                producingCountry.equals(that.producingCountry) &&
                categories.equals(that.categories);
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categories);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producingCountry='" + producingCountry + '\'' +
                ", yearOfIssue='" + yearOfIssue + '\'' +
                ", categories=" + categories +
                '}';
    }
}
