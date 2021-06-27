package mapper;

import dto.entity.ProductsByShopDto;
import entity.ProductsByShop;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductByShopMapper {

    ProductsByShopMapper productsByShopMapper = new ProductsByShopMapper(MockData.products);

    @Test
    public void toDtoTest(){
        ProductsByShopDto productsByShopDto = productsByShopMapper.toDto(MockData.productsByShops.get(0));
        ProductsByShopDto productsByShopDto1 = new ProductsByShopDto(1l, 1l, 5, 100);
        Assert.assertEquals(productsByShopDto,productsByShopDto1);
    }

    @Test
    public void toEntity(){
        ProductsByShopDto productsByShopDto = productsByShopMapper.toDto(MockData.productsByShops.get(0));
        ProductsByShop productsByShop = productsByShopMapper.toEntity(productsByShopDto);
        Assert.assertEquals(MockData.productsByShops.get(0),productsByShop);
    }

}
