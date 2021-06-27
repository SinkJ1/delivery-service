package dao;

import entity.Category;
import entity.Product;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class ProductRepositoryTest {

    private final String pathToProduct = "src/test/resources/data/product.json";
    ProductRepository productRepository = new ProductRepositoryImpl(pathToProduct, MockData.categories);
    public Predicate<Product> productCategoryEQ(List<Category> categories) {
        return e -> e.getCategories().equals(categories);
    }

    Product product = new Product(new Date().getTime(),"name 123", "USA", 2020,MockData.categories);


    @Test
    public void createTest(){


        productRepository.create(product);
        Product product1 = productRepository.read(product.getId());
        Assert.assertEquals(product, product1);
    }

    @Test
    public void updateTest(){
        Product product1 = productRepository.readAll().get(0);
        product1.setName("new name");
        productRepository.update(product1);
        Product product2 = productRepository.readAll().get(0);
        Assert.assertEquals(product1, product2);
    }


    @Test
    public void deleteTest(){
        productRepository.delete(product);
        Assert.assertFalse( productRepository.readAll().contains(product));
    }

    @Test
    public void getProductByAttributesTest() {
        Predicate<Product>[] predicates = new Predicate[]{productCategoryEQ(MockData.categories2)};
        List<Product> products = productRepository.filter(predicates);
        Assert.assertTrue(products.isEmpty());
    }

}
