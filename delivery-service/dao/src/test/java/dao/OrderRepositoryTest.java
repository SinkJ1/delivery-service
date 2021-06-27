package dao;

import entity.Order;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class OrderRepositoryTest {


    private final String orderPath = "src/test/resources/data/order.json";

    BaseRepository<Order, Long> orderRepository = new OrderRepositoryImpl(orderPath, MockData.clients,MockData.shops,MockData.products);
    Order order = MockData.orders.get(0);

    @Test
    public void createOrder() {
        order.setId(new Date().getTime());
        orderRepository.create(order);
        Order order1 = orderRepository.read(order.getId());
        Assert.assertEquals(order, order1);
    }

    @Test
    public void updateOrder() {
        Order order1 = orderRepository.readAll().get(0);
        order1.setClient(MockData.clients.get(0));
        orderRepository.update(order1);
        Order order2 = orderRepository.readAll().get(0);
        Assert.assertEquals(order1, order2);
    }


    @Test
    public void deleteOrder() {
        orderRepository.delete(order);
        Assert.assertFalse(orderRepository.readAll().contains(order));
    }

}
