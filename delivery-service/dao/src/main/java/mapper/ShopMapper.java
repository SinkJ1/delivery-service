package mapper;

import dao.ProductsByShopRepository;
import dao.ProductsByShopRepositoryImpl;
import dao.ShopRepository;
import dao.ShopRepositoryImpl;
import dto.entity.ShopDto;
import entity.ProductsByShop;
import entity.Shop;

import java.util.stream.Collectors;


public class ShopMapper extends BaseMapper<Shop, ShopDto> {

    ShopRepository shopRepository;
    ProductsByShopRepository productsByShopRepository;
    IdEntityMapper<ProductsByShop> productIdMapper;

    ShopMapper(Class<Shop> entityClass, Class<ShopDto> dtoClass) {
        super(entityClass, dtoClass);
        this.shopRepository = new ShopRepositoryImpl("");
        this.productsByShopRepository = new ProductsByShopRepositoryImpl("");
        this.productIdMapper = new IdEntityMapper<>();
        setupMapper();
    }

    public void setupMapper() {
        mapper.createTypeMap(Shop.class, ShopDto.class)
                .addMappings(m -> m.skip(ShopDto::setProducts)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ShopDto.class, Shop.class)
                .addMappings(m -> m.skip(Shop::setProducts)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEntity(Shop shop, ShopDto shopDto) {
        shopDto.setProducts(productIdMapper.getId(shop.getProducts(), (ProductsByShop product) -> product.getId()));
    }

    @Override
    void mapSpecificFieldsDto(ShopDto shopDto, Shop shop) {
        shop.setProducts(shopDto.getProducts().stream().map(e -> productIdMapper.toEntity(productsByShopRepository.readAll(), c -> c.getId() == e)).collect(Collectors.toList()));
    }
}
