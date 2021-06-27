package dao;

import dto.entity.OrderDto;
import entity.Client;
import entity.Order;
import entity.Product;
import entity.Shop;
import mapper.OrderMapper;

import java.util.List;

public class OrderRepositoryImpl extends BaseDao<Order, OrderDto, Long> implements OrderRepository {

    public OrderRepositoryImpl(String path, List<Client> clients, List<Shop> shops, List<Product> products) {
        super(path, new OrderMapper(clients, shops, products));
    }

    @Override
    protected Class<OrderDto[]> getDClass() {
        return OrderDto[].class;
    }

    @Override
    protected Order getById(Long id, List<Order> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(Order entity) {
        List<Order> orders = readAll();
        List<OrderDto> dtoList;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId().equals(entity.getId())) {
                orders.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(orders);
        write(dtoList);
    }
}
