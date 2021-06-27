package mockData;

import entity.*;

import java.util.List;

public class MockData {

    public static List<Client> clients = List.of(
            new Client(1l, "name ", "Hrodna"),
            new Client(2l, "name 1", "Minsk"),
            new Client(3l, "name 2", "Brest"),
            new Client(4l, "name 3", "Gomel")
    );

    public static List<Category> categories = List.of(
            new Category(1l, "category"),
            new Category(2l, "category 1"),
            new Category(3l, "category 2"),
            new Category(4l, "category 3")
    );

    public static List<Category> categories2 = List.of(
            new Category(5l, "category3"),
            new Category(6l, "category 4"),
            new Category(7l, "category 5"),
            new Category(8l, "category 6")
    );

    public static List<Product> products = List.of(
            new Product(1l, "bread", "Russia", 2020 , categories),
            new Product(3l, "milk", "Russia", 2020 , categories),
            new Product(4l, "water", "Russia", 2020 , categories),
            new Product(5l, "ice", "Russia", 2020 , categories)
    );

    public static List<ProductsByShop> productsByShops = List.of(
            new ProductsByShop(1l, products.get(0), 5, 250),
            new ProductsByShop(2l, products.get(1), 5, 300),
            new ProductsByShop(3l, products.get(2), 5, 415),
            new ProductsByShop(4l, products.get(3), 5, 10)
    );

    public static List<Shop> shops = List.of(new Shop(1l, "shop", productsByShops));

    public static List<Order> orders = List.of(new Order(1l, clients.get(0), products, shops.get(0)));


}
