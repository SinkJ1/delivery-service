package dao;

import entity.Shop;

import java.util.List;

public class ShopRepositoryImpl extends BaseDao<Shop, Long> implements ShopRepository{
    public ShopRepositoryImpl(String path) {
        super(path, MockData.shops);
    }

    @Override
    protected Class<Shop[]> getTClass() {
        return Shop[].class;
    }

    @Override
    protected Shop getById(Long id, List<Shop> entities) {
        return null;
    }
}
