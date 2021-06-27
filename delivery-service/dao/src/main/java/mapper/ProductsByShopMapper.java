package mapper;

import dto.entity.ProductsByShopDto;
import entity.Product;
import entity.ProductsByShop;

import java.util.List;

public class ProductsByShopMapper extends BaseMapper<ProductsByShop, ProductsByShopDto>{

    private List<Product> products;

    public ProductsByShopMapper(List<Product> products) {
        super(ProductsByShop.class, ProductsByShopDto.class);
        this.products = products;
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
        dto.setProduct(entity.getProduct().getId());
    }

    @Override
    void mapSpecificFieldsDto(ProductsByShopDto dto, ProductsByShop entity) {
        entity.setProduct(products.stream().filter(product -> dto.getProduct().equals(product.getId())).findFirst().get());
    }
}
