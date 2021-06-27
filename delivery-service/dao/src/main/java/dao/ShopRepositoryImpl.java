package dao;

import dto.entity.ShopDto;
import entity.ProductsByShop;
import entity.Shop;
import mapper.ShopMapper;

import java.util.List;

public class ShopRepositoryImpl extends BaseDao<Shop, ShopDto, Long> implements ShopRepository {
    public ShopRepositoryImpl(String path, List<ProductsByShop> productsByShops) {
        super(path, new ShopMapper(productsByShops));
    }

    @Override
    protected Class<ShopDto[]> getDClass() {
        return ShopDto[].class;
    }

    @Override
    protected Shop getById(Long id, List<Shop> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(Shop entity) {
        List<Shop> shops = readAll();
        List<ShopDto> dtoList;
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).getId().equals(entity.getId())) {
                shops.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(shops);
        write(dtoList);
    }
}
