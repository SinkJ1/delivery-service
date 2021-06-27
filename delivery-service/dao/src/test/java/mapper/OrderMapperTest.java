package mapper;

import dto.entity.OrderDto;
import entity.Order;
import mockData.MockData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OrderMapperTest {

    OrderMapper orderMapper = new OrderMapper(MockData.clients, MockData.shops, MockData.products);

    @Test
    public void mapToDtoTest() {
        OrderDto orderDto = orderMapper.toDto(MockData.orders.get(0));
        OrderDto orderDto1 = new OrderDto(1L, 1l, List.of(1L, 2L), 1l);
        Assert.assertEquals(orderDto, orderDto1);
    }

    @Test
    public void mapToEntityTest() {
        OrderDto orderDto = orderMapper.toDto(MockData.orders.get(0));
        Order entity = orderMapper.toEntity(orderDto);
        Assert.assertEquals(MockData.orders.get(0), entity);
    }


}
