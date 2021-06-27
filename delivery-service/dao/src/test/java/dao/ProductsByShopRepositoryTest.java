package dao;

import entity.ProductsByShop;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsByShopRepositoryTest {

    private final String productsByShopPath = "src/test/resources/data/productsByShop.json";

    BaseRepository<ProductsByShop, Long> productsByShopRepository = new ProductsByShopRepositoryImpl(productsByShopPath, MockData.products);
    ProductsByShop productsByShop = MockData.productsByShops.get(0);

    @Test
    public void createProductByShop() {
        productsByShopRepository.create(productsByShop);
        ProductsByShop productsByShop1 = productsByShopRepository.read(productsByShop.getId());
        Assert.assertEquals(productsByShop, productsByShop1);

    }

    @Test
    public void updateProductByShop() {
        ProductsByShop productsByShop1 = productsByShopRepository.readAll().get(0);
        productsByShop1.setCost(15);
        productsByShopRepository.update(productsByShop1);
        ProductsByShop productsByShop2 = productsByShopRepository.readAll().get(0);
        Assert.assertEquals(productsByShop1, productsByShop2);
    }


    @Test
    public void deleteProductByShop() {
        productsByShopRepository.delete(productsByShop);
        Assert.assertFalse(productsByShopRepository.readAll().contains(productsByShop));
    }


}
