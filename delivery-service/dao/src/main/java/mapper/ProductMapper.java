package mapper;

import dao.CategoryRepository;
import dao.CategoryRepositoryImpl;
import dao.ProductRepository;
import dao.ProductRepositoryImpl;
import dto.entity.ProductDto;
import entity.Category;
import entity.Product;

import java.util.stream.Collectors;

public class ProductMapper extends BaseMapper<Product, ProductDto> {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    IdEntityMapper<Category> categoryMapper;

    public ProductMapper(String pathToProduct, String pathToCategory) {
        super(Product.class, ProductDto.class);
        this.productRepository = new ProductRepositoryImpl(pathToProduct);
        this.categoryRepository = new CategoryRepositoryImpl(pathToCategory);
        this.categoryMapper = new IdEntityMapper<>();
        setupMapper();
    }

    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setCategories)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setCategories)).setPostConverter(toEntityConverter());
    }

    public void mapSpecificFieldsEntity(Product product, ProductDto productDto) {
        productDto.setCategories(categoryMapper.getId(product.getCategories(), (Category category) -> category.getId()));
    }


    public void mapSpecificFieldsDto(ProductDto productDto, Product product) {
        product.setCategories(productDto.getCategories().stream().map(e -> categoryMapper.toEntity(categoryRepository.readAll(), c -> c.getId() == e)).collect(Collectors.toList()));
    }

}
