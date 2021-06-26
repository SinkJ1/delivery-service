package dto.entity;

import java.util.List;
import java.util.Objects;

public class ShopDto {

    private long id;
    private String name;
    private List<Long> products;

    public ShopDto(long id, String name, List<Long> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public ShopDto(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDto shopDto = (ShopDto) o;
        return id == shopDto.id &&
                name.equals(shopDto.name) &&
                products.equals(shopDto.products);
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

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
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
