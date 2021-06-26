package entity;

import java.util.List;
import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private String producingCountry;
    private int yearOfIssue;
    private List<Category> categories;


    public Product(){

    }

    public Product(long id, String name, String producingCountry, int yearOfIssue, List<Category> categories) {
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
        Product product = (Product) o;
        return id == product.id &&
                yearOfIssue == product.yearOfIssue &&
                name.equals(product.name) &&
                producingCountry.equals(product.producingCountry) &&
                categories.equals(product.categories);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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
