package dao;

import entity.Product;

import java.util.List;

public class ProductRepositoryImpl extends BaseDao<Product, Long> implements ProductRepository {

    public ProductRepositoryImpl(String path) {
        super(path, MockData.products);
    }

    @Override
    protected Class<Product[]> getTClass() {
        return null;
    }

    @Override
    protected Product getById(Long id, List<Product> entities) {
        return entities.stream().filter(e -> e.getId() == id).findFirst().get();
    }

}
