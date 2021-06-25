package entity;

import java.util.List;
import java.util.Objects;

public class Shop {

    private long id;
    private String name;
    private List<ProductsByShop> products;

    public Shop(long id, String name, List<ProductsByShop> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id &&
                name.equals(shop.name) &&
                products.equals(shop.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductsByShop> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsByShop> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
