package dao;

import entity.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class CategoryRepositoryTest {


    private final String categoryPath = "src/test/resources/data/category.json";

    BaseRepository<Category, Long> categoryRepository = new CategoryRepositoryImpl(categoryPath);
    Category category = new Category(new Date().getTime(), "name");

    @Test
    public void createCategory() {
        categoryRepository.create(category);
        Category category1 = categoryRepository.read(category.getId());
        Assert.assertEquals(category, category1);

    }

    @Test
    public void updateCategory() {
        Category category1 = categoryRepository.readAll().get(0);
        category1.setName("new name");
        categoryRepository.update(category1);
        Category category2 = categoryRepository.readAll().get(0);
        Assert.assertEquals(category1, category2);
    }


    @Test
    public void deleteCategory() {
        categoryRepository.delete(category);
        Assert.assertFalse(categoryRepository.readAll().contains(category));
    }

}
