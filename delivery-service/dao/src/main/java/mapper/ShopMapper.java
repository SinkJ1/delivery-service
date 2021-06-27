package mapper;

import dto.entity.ShopDto;
import entity.ProductsByShop;
import entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ShopMapper extends BaseMapper<Shop, ShopDto> {

    private List<ProductsByShop> productsByShops;

    public ShopMapper(List<ProductsByShop> productsByShops) {
        super(Shop.class, ShopDto.class);
        this.productsByShops = productsByShops;
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
        shopDto.setProducts(shop.getProducts().stream().map(productsByShop -> productsByShop.getId()).collect(Collectors.toList()));
    }

    @Override
    void mapSpecificFieldsDto(ShopDto shopDto, Shop shop) {

        List<ProductsByShop> productList = new ArrayList<>();

        for(Long productId: shopDto.getProducts()){
            for(ProductsByShop product : productsByShops){
                if(productId.equals(product.getId())){
                    productList.add(product);
                }
            }
        }

        shop.setProducts(productList);
    }
}
