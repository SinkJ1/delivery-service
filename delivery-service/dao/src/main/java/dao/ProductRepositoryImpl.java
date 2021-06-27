package dao;

import dto.entity.ProductDto;
import entity.Category;
import entity.Product;
import mapper.ProductMapper;

import java.util.List;

public class ProductRepositoryImpl extends BaseDao<Product, ProductDto, Long> implements ProductRepository {

    public ProductRepositoryImpl(String path, List<Category> categories) {
        super(path, new ProductMapper(categories));
    }

    @Override
    protected Class<ProductDto[]> getDClass() {
        return ProductDto[].class;
    }

    @Override
    protected Product getById(Long id, List<Product> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(Product entity) {
        List<Product> products = readAll();
        List<ProductDto> dtoList;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(entity.getId())) {
                products.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(products);
        write(dtoList);
    }

}
