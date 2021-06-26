package IdConverter;

import dao.CategoryRepositoryImpl;
import dao.ClientRepositoryImpl;
import dao.MockData;
import dao.Repository;
import mapper.IdEntityMapper;
import entity.Category;
import entity.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IdConverter {

    private final String clientPath = "src/test/resources/data/client.json";

    Repository<Client, Long> clientRepository = new ClientRepositoryImpl(clientPath);
    Repository<Category, Long> categoryRepository = new CategoryRepositoryImpl(clientPath);

    public Predicate<Category> idEQ(Long id) {
        return e -> e.getId() == id;
    }

    @Test
    public void convertToIdTest(){
        IdEntityMapper<Client> clientMapper = new IdEntityMapper<>();
        List<Long> clientIdes = clientMapper.getId(clientRepository.readAll(), client -> client.getId());
        List<Long> ides = List.of(1L,2l,3l,4l);
        Assert.assertEquals(clientIdes,ides);
    }

    @Test
    public void convertToEntityTest(){
        IdEntityMapper<Category> categoryMapper = new IdEntityMapper<>();
        List<Long> ides = categoryMapper.getId(categoryRepository.readAll(), category -> category.getId());
        List<Category> categoryList = ides.stream().map(e-> categoryMapper.toEntity(categoryRepository.readAll(), idEQ(e))).collect(Collectors.toList());
        Assert.assertEquals(MockData.categories,categoryList);
    }


}
