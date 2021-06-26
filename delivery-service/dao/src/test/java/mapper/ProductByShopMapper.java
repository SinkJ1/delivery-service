package mapper;

import dao.MockData;
import dto.entity.ProductsByShopDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductByShopMapper {

    @Test
    public void toDtoTest(){
        ProductsByShopMapper productsByShopMapper = new ProductsByShopMapper();
        ProductsByShopDto productsByShopDto = productsByShopMapper.toDto(MockData.productsByShops.get(0));
        ProductsByShopDto productsByShopDto1 = new ProductsByShopDto(1l, 1l, 5, 100);
        Assert.assertEquals(productsByShopDto,productsByShopDto1);

    }


}
