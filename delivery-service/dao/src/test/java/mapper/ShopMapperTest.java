package mapper;

import dao.MockData;
import dto.entity.ShopDto;
import entity.Shop;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShopMapperTest {

    @Test
    public void toDtoTest(){

        ShopMapper shopMapper = new ShopMapper(Shop.class, ShopDto.class);

        ShopDto shopDto = shopMapper.toDto(MockData.shops.get(0));
        ShopDto shopDto1 = new ShopDto(1l, "shop", List.of(1l));
        Assert.assertEquals(shopDto,shopDto1);

    }


}
