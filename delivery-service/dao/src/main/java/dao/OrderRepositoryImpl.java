package dao;

import entity.Order;

import java.util.List;

public class OrderRepositoryImpl extends BaseDao<Order, Long> implements OrderRepository{

    public OrderRepositoryImpl(String path) {
        super(path, MockData.orders);
    }

    @Override
    protected Class<Order[]> getTClass() {
        return Order[].class;
    }

    @Override
    protected Order getById(Long id, List<Order> entities) {
        return null;
    }
}
