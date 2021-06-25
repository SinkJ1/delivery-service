package dao;

import entity.Shop;

import java.util.List;

public class ShopRepositoryImpl extends BaseDao<Shop, Long> implements ShopRepository{
    public ShopRepositoryImpl(String path, List<Shop> entities) {
        super(path, entities);
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
