package dao;

import entity.*;

import java.util.Date;
import java.util.List;

public class MockData {

    static List<Client> clients = List.of(
            new Client(new Date().getTime(), "name ", "Hrodna"),
            new Client(new Date().getTime(), "name 1", "Minsk"),
            new Client(new Date().getTime(), "name 2", "Brest"),
            new Client(new Date().getTime(), "name 3", "Gomel")
    );

    static List<Category> categories = List.of(
            new Category(new Date().getTime(), "category"),
            new Category(new Date().getTime(), "category 1"),
            new Category(new Date().getTime(), "category 2"),
            new Category(new Date().getTime(), "category 3")
    );

    static List<Category> categories2 = List.of(
            new Category(new Date().getTime(), "category3"),
            new Category(new Date().getTime(), "category 4"),
            new Category(new Date().getTime(), "category 5"),
            new Category(new Date().getTime(), "category 6")
    );

    static List<Product> products = List.of(
            new Product(new Date().getTime(), "product", "Russia", 2020 , categories),
            new Product(new Date().getTime(), "product", "Russia", 2021 , categories2)
    );

    static List<ProductsByShop> productsByShops = List.of(
            new ProductsByShop(new Date().getTime(), products.get(0), 5, 100)
    );

    static List<Shop> shops = List.of(new Shop(new Date().getTime(), "shop", productsByShops));

    static List<Order> orders = List.of(new Order(new Date().getTime(), clients.get(0), products, shops.get(0)));


}
