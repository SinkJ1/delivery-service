package dto.entity;

import java.util.Objects;

public class ProductsByShopDto {

    private Long id;
    private Long product;
    private int count;
    private float cost;

    public ProductsByShopDto(Long id, Long product, int count, float cost) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.cost = cost;
    }

    public ProductsByShopDto() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsByShopDto that = (ProductsByShopDto) o;
        return count == that.count &&
                Float.compare(that.cost, cost) == 0 &&
                id.equals(that.id) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, count, cost);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
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
