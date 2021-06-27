package service;

import entity.Category;
import entity.Product;
import entity.ProductsByShop;
import entity.Shop;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.impl.ProductsByShopServiceImpl;
import service.impl.ShopServiceImpl;

import java.util.Comparator;
import java.util.List;

public class ShopServiceTest {

    BaseService<Shop, Long> shopService = new ShopServiceImpl();
    BaseService<ProductsByShop, Long> productsByShopService = new ProductsByShopServiceImpl();


    public List<Category> categories = List.of(
            new Category(1l, "category"),
            new Category(2l, "category 1"),
            new Category(3l, "category 2"),
            new Category(4l, "category 3")
    );

    public List<Product> products = List.of(
            new Product(1l, "bread", "Russia", 2020, categories),
            new Product(3l, "milk", "Russia", 2020, categories),
            new Product(4l, "water", "Russia", 2020, categories),
            new Product(5l, "ice", "Russia", 2020, categories)
    );

    public List<ProductsByShop> productsByShops = List.of(
            new ProductsByShop(3l, products.get(2), 5, 415),
            new ProductsByShop(2l, products.get(1), 5, 300),
            new ProductsByShop(1l, products.get(0), 5, 250),
            new ProductsByShop(4l, products.get(3), 5, 10)
    );

    public List<ProductsByShop> productsByShops1 = List.of(
            new ProductsByShop(3l, products.get(2), 5, 415),
            new ProductsByShop(2l, products.get(1), 5, 300),
            new ProductsByShop(4l, products.get(3), 5, 10),
            new ProductsByShop(1l, products.get(0), 5, 250)
    );

    @Test
    public void sortProductsByCostTrue() {

        Shop shop = MockData.shops.get(1);

        List<ProductsByShop> sortedList = productsByShopService.sort(shop.getProducts(), Comparator.comparing(s -> s.getCost()));
        List<ProductsByShop> sortedList1 = productsByShops;
        Assert.assertEquals(sortedList, sortedList1);
    }

    @Test
    public void sortProductsByCostFalse() {

        Shop shop = MockData.shops.get(0);

        List<ProductsByShop> sortedList = productsByShopService.sort(shop.getProducts(), Comparator.comparing(s -> s.getCost()));
        List<ProductsByShop> sortedList1 = productsByShops1;
        Assert.assertNotEquals(sortedList, sortedList1);
    }

}
