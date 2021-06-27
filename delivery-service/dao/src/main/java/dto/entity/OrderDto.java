package dto.entity;

import java.util.List;
import java.util.Objects;

public class OrderDto {

    private Long id;
    private Long clientId;
    private List<Long> products;
    private Long shopId;

    public OrderDto(Long id, Long clientId, List<Long> products, Long shopId) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
        this.shopId = shopId;
    }

    public OrderDto() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return id.equals(orderDto.id) &&
                clientId.equals(orderDto.clientId) &&
                products.equals(orderDto.products) &&
                shopId.equals(orderDto.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, products, shopId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", products=" + products +
                ", shopId=" + shopId +
                '}';
    }
}
