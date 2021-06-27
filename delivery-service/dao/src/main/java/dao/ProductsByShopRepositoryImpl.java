package dao;

import dto.entity.ProductsByShopDto;
import entity.Product;
import entity.ProductsByShop;
import mapper.ProductsByShopMapper;

import java.util.List;

public class ProductsByShopRepositoryImpl extends BaseDao<ProductsByShop, ProductsByShopDto, Long> implements ProductsByShopRepository {

    public ProductsByShopRepositoryImpl(String path, List<Product> products) {
        super(path, new ProductsByShopMapper(products));
    }

    @Override
    protected Class<ProductsByShopDto[]> getDClass() {
        return ProductsByShopDto[].class;
    }

    @Override
    protected ProductsByShop getById(Long id, List<ProductsByShop> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(ProductsByShop entity) {
        List<ProductsByShop> productsByShop = readAll();
        List<ProductsByShopDto> dtoList;
        for (int i = 0; i < productsByShop.size(); i++) {
            if (productsByShop.get(i).getId().equals(entity.getId())) {
                productsByShop.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(productsByShop);
        write(dtoList);
    }
}
