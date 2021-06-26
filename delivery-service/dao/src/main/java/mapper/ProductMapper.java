package mapper;

import dao.CategoryRepository;
import dao.CategoryRepositoryImpl;
import dto.entity.ProductDto;
import entity.Category;
import entity.Product;
import org.modelmapper.ExpressionMap;

import java.util.List;

public class ProductMapper extends BaseMapper<Product, ProductDto> {

    CategoryRepository categoryRepository;
    IdEntityMapper<Category> categoryMapper;

    public ProductMapper(String pathToCategory) {
        this.categoryRepository = new CategoryRepositoryImpl(pathToCategory);
        this.categoryMapper = new IdEntityMapper<>();
    }

    protected List<Long> getIdes() {
        return categoryMapper.getId(categoryRepository.readAll(), category -> category.getId());
    }

    @Override
    protected Class<Product> getTClass() {
        return Product.class;
    }

    @Override
    protected Class<ProductDto> getYClass() {
        return ProductDto.class;
    }

    @Override
    protected List<ExpressionMap<Product,ProductDto>> getExpressionMap() {
        return List.of(m -> m.map(categories -> getIdes(), ProductDto::setCategories));
    }


}
