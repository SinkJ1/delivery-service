package mapper;

import dao.ProductRepository;
import dao.ProductRepositoryImpl;
import dto.entity.ProductsByShopDto;
import entity.ProductsByShop;

public class ProductsByShopMapper extends BaseMapper<ProductsByShop, ProductsByShopDto>{

    private ProductRepository productRepository;

    ProductsByShopMapper() {
        super(ProductsByShop.class, ProductsByShopDto.class);
        this.productRepository = new ProductRepositoryImpl("");
        setupMapper();
    }

    public void setupMapper() {
        mapper.createTypeMap(ProductsByShop.class, ProductsByShopDto.class)
                .addMappings(m -> m.skip(ProductsByShopDto::setProduct)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductsByShopDto.class, ProductsByShop.class)
                .addMappings(m -> m.skip(ProductsByShop::setProduct)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEntity(ProductsByShop entity, ProductsByShopDto dto) {
        dto.setProduct(entity.getId());
    }

    @Override
    void mapSpecificFieldsDto(ProductsByShopDto dto, ProductsByShop entity) {
        entity.setProduct(productRepository.read(dto.getProduct()));
    }
}
