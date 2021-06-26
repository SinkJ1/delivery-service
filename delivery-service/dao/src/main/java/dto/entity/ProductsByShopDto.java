package dto.entity;

import java.util.Objects;

public class ProductsByShopDto {

    private long id;
    private ProductDto product;
    private int count;
    private float cost;

    public ProductsByShopDto(long id, ProductDto products, int count, float cost) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsByShopDto that = (ProductsByShopDto) o;
        return id == that.id &&
                count == that.count &&
                Float.compare(that.cost, cost) == 0 &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, count, cost);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductsByShop{" +
                "id=" + id +
                ", product=" + product +
                ", count=" + count +
                ", cost=" + cost +
                '}';
    }
}
