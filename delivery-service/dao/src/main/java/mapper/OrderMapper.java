package mapper;


import dto.entity.OrderDto;
import entity.Client;
import entity.Order;
import entity.Product;
import entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper extends BaseMapper<Order, OrderDto>{

    private List<Client> clients;
    private List<Shop> shops;
    private List<Product> products;

    public OrderMapper(List<Client> clients, List<Shop> shops, List<Product> products) {
        super(Order.class, OrderDto.class);
        this.clients = clients;
        this.shops = shops;
        this.products = products;
        setupMapper();
    }

    public void setupMapper() {
        mapper.createTypeMap(Order.class, OrderDto.class)
                .addMappings(m -> m.skip(OrderDto::setProducts)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(OrderDto.class, Order.class)
                .addMappings(m -> m.skip(Order::setProducts)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEntity(Order order, OrderDto orderDto) {
        orderDto.setClientId(order.getClient().getId());
        orderDto.setShopId(order.getShop().getId());
        orderDto.setProducts(order.getProducts().stream().map(o -> o.getId()).collect(Collectors.toList()));
    }

    @Override
    void mapSpecificFieldsDto(OrderDto orderDto, Order order) {
        for(Client client : clients){
            if(client.getId().equals(orderDto.getClientId())){
                order.setClient(client);
            }
        }

        for(Shop shop : shops){
            if(shop.getId().equals(orderDto.getShopId())){
                order.setShop(shop);
            }
        }

        List<Product> productList = new ArrayList<>();

        for(Long productId : orderDto.getProducts()){
            for(Product product: products){
                if(product.getId().equals(productId)){
                    productList.add(product);
                }
            }
        }

        order.setProducts(productList);

    }
}
