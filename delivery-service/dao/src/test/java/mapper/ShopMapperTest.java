package mapper;

import dto.entity.ShopDto;
import entity.Shop;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShopMapperTest {

    ShopMapper shopMapper = new ShopMapper(MockData.productsByShops);

    @Test
    public void toDtoTest() {
        ShopDto shopDto = shopMapper.toDto(MockData.shops.get(0));
        ShopDto shopDto1 = new ShopDto(1l, "shop", List.of(1l));
        Assert.assertEquals(shopDto, shopDto1);

    }

    @Test
    public void toEntityTest() {
        ShopDto shopDto = shopMapper.toDto(MockData.shops.get(0));
        Shop shop = shopMapper.toEntity(shopDto);
        Assert.assertEquals(shop, MockData.shops.get(0));

    }


}
