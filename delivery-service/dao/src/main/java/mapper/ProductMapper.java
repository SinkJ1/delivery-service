package mapper;

import dto.entity.ProductDto;
import entity.Category;
import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper extends BaseMapper<Product, ProductDto> {

    private List<Category> categories;

    public ProductMapper(List<Category> categories) {
        super(Product.class, ProductDto.class);
        this.categories = categories;
        setupMapper();
    }

    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setCategories)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setCategories)).setPostConverter(toEntityConverter());
    }

    public void mapSpecificFieldsEntity(Product product, ProductDto productDto) {
        productDto.setCategories(categories.stream().map((category -> category.getId())).collect(Collectors.toList()));
    }


    public void mapSpecificFieldsDto(ProductDto productDto, Product product) {
        List<Category> categoryList = new ArrayList<>();

        for (Long categoryId : productDto.getCategories()) {
            for (Category category : categories) {
                if (category.getId().equals(categoryId)) {
                    categoryList.add(category);
                }
            }
        }
        product.setCategories(categoryList);

    }

}
