package dto.entity;

import java.util.List;
import java.util.Objects;

public class OrderDto {

    private long id;
    private ClientDto clientDto;
    private List<Long> products;
    private ShopDto shopDto;

    public OrderDto(long id, ClientDto clientDto, List<Long> products, ShopDto shopDto) {
        this.id = id;
        this.clientDto = clientDto;
        this.products = products;
        this.shopDto = shopDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto order = (OrderDto) o;
        return id == order.id &&
                clientDto.equals(order.clientDto) &&
                products.equals(order.products) &&
                shopDto.equals(order.shopDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientDto, products, shopDto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClientDto getClient() {
        return clientDto;
    }

    public void setClient(ClientDto clientDto) {
        this.clientDto = clientDto;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public ShopDto getShop() {
        return shopDto;
    }

    public void setShop(ShopDto shopDto) {
        this.shopDto = shopDto;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + clientDto +
                ", products=" + products +
                ", shop=" + shopDto +
                '}';
    }
}
