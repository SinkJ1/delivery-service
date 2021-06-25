package dao;

import entity.Category;
import entity.Product;

import java.util.List;
import java.util.function.Predicate;

public interface ProductRepository extends Repository <Product, Long>{

    List<Product> getProductByCategories(List<Category> category);

    List<Product> getProductByAttributes(Predicate<Product> ...predicates);

}
