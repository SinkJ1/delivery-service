package dao;

import entity.ProductsByShop;

import java.util.List;

public class ProductsByShopRepositoryImpl extends BaseDao<ProductsByShop, Long> implements ProductsByShopRepository{

    public ProductsByShopRepositoryImpl(String path) {
        super(path, MockData.productsByShops);
    }

    @Override
    protected Class<ProductsByShop[]> getTClass() {
        return ProductsByShop[].class;
    }

    @Override
    protected ProductsByShop getById(Long id, List<ProductsByShop> entities) {
        return null;
    }
}
