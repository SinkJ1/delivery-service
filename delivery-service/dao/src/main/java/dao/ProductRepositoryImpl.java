package dao;

import entity.Category;
import entity.Product;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepositoryImpl extends BaseDao<Product, Long> implements ProductRepository {

    public ProductRepositoryImpl(String path, List<Product> entities) {
        super(path, entities);
    }

    @Override
    protected Class<Product[]> getTClass() {
        return null;
    }

    @Override
    protected Product getById(Long id, List<Product> entities) {
        return null;
    }

    @Override
    public List<Product> getProductByCategories(List<Category> category) {
        return null;
    }

    @Override
    public List<Product> getProductByAttributes(Predicate<Product>... predicates) {
        Stream<Product> result = readAll().stream();
        for (Predicate<Product> predicate : predicates) {
            result = result.filter(predicate);
        }
        return result.collect(Collectors.toList());
    }

}
