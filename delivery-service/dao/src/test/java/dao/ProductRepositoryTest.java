package dao;

import entity.Category;
import entity.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductRepositoryTest {

    public Predicate<Product> nameEQ(String name) {
        return e -> e.getName().equals(name);
    }

    public Predicate<Product> countryEQ(String country) {
        return e -> e.getProducingCountry().equals(country);
    }

    public Predicate<Product> yearGT(int year) {
        return e -> e.getYearOfIssue() > year;
    }

    public Predicate<Product> yearLT(int year) {
        return e -> e.getYearOfIssue() < year;
    }

    public Predicate<Product> yearEQ(int year) {
        return e -> e.getYearOfIssue() == year;
    }

    public Predicate<Product> productCategoryEQ(List<Category> categories) {
        return e -> e.getCategories().equals(categories);
    }

    ProductRepository productRepository = new ProductRepositoryImpl("");

    @Test
    public void getProductByAttributesTest() {
        List<Category> categories = MockData.products.get(0).getCategories();
        Predicate<Product>[] predicates = new Predicate[]{productCategoryEQ(categories)};
        List<Product> products = new ArrayList<>();
        List<Product> products2 = List.of(MockData.products.get(0));

        Assert.assertEquals(products,products2);
    }

}
