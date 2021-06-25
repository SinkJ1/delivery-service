package entity;

import java.util.List;
import java.util.Objects;

public class Order {

    private long id;
    private Client client;
    private List<Product> products;
    private Shop shop;

    public Order(long id, Client client, List<Product> products, Shop shop) {
        this.id = id;
        this.client = client;
        this.products = products;
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                client.equals(order.client) &&
                products.equals(order.products) &&
                shop.equals(order.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, products, shop);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", products=" + products +
                ", shop=" + shop +
                '}';
    }
}
