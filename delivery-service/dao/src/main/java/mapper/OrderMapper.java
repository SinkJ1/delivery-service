package mapper;

import dao.ProductRepository;
import dao.ProductRepositoryImpl;
import dto.entity.OrderDto;
import entity.Order;
import entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;


public class OrderMapper {

    public ModelMapper map(Order order, OrderDto orderDto){

        ProductRepository productRepository = new ProductRepositoryImpl("");
        IdEntityMapper<Product> categoryMapper = new IdEntityMapper<>();
        List<Long> ides = categoryMapper.getId(productRepository.readAll(), category -> category.getId());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.typeMap(Order.class, OrderDto.class)
                .addMappings(m -> m.map(src -> ides, OrderDto::setProducts));
        return mapper;
    }

}
