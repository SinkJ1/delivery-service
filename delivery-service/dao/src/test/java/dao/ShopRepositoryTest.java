package dao;

import entity.Shop;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopRepositoryTest {

    private final String shopPath = "src/test/resources/data/shop.json";

    BaseRepository<Shop, Long> shopRepository = new ShopRepositoryImpl(shopPath,MockData.productsByShops);
    Shop shop = MockData.shops.get(0);

    @Test
    public void createShop() {
        shopRepository.create(shop);
        Shop shop1 = shopRepository.read(shop.getId());
        Assert.assertEquals(shop, shop1);

    }

    @Test
    public void updateShop() {
        Shop shop1 = shopRepository.readAll().get(0);
        shop1.setName("new name");
        shopRepository.update(shop1);
        Shop shop2 = shopRepository.readAll().get(0);
        Assert.assertEquals(shop1, shop2);
    }


    @Test
    public void deleteShop() {
        shopRepository.delete(shop);
        Assert.assertFalse(shopRepository.readAll().contains(shop));
    }

}
