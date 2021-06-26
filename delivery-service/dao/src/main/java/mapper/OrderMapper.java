package mapper;


import dao.OrderRepository;
import dao.OrderRepositoryImpl;
import dao.ProductRepository;
import dao.ProductRepositoryImpl;
import dto.entity.OrderDto;
import entity.Order;
import entity.Product;

import java.util.stream.Collectors;

public class OrderMapper extends BaseMapper<Order, OrderDto>{

    ProductRepository productRepository;
    OrderRepository orderRepository;
    IdEntityMapper<Product> productIdMapper;

    OrderMapper(Class<Order> entityClass, Class<OrderDto> dtoClass) {
        super(entityClass, dtoClass);
        this.productRepository = new ProductRepositoryImpl("");
        this.orderRepository = new OrderRepositoryImpl("");
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
        orderDto.setProducts(productIdMapper.getId(order.getProducts(), (Product product) -> product.getId()));
    }

    @Override
    void mapSpecificFieldsDto(OrderDto orderDto, Order order) {
        order.setProducts(orderDto.getProducts().stream().map(e -> productIdMapper.toEntity(productRepository.readAll(), c -> c.getId() == e)).collect(Collectors.toList()));
    }
}
