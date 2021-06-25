package dao;

import entity.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRepositoryTest {

    private final String clientPath = "src/test/resources/data/client.json";

    Repository<Client, Long> clientRepository = new ClientRepositoryImpl(clientPath, MockData.clients);
    Client client = new Client(25L, "name", "Brest");

    @Test
    public void createTest(){
        clientRepository.create(client);
        Client client1 = clientRepository.read(client.getId());
        Assert.assertEquals(client, client1);

    }

    @Test
    public void updateTest(){

        Client client1 = clientRepository.readAll().get(0);
        client1.setName("new name");
        Client client2 = clientRepository.readAll().get(0);
        Assert.assertEquals(client1, client2);
    }


    @Test
    public void deleteTest(){
        clientRepository.delete(client);
        Assert.assertFalse(MockData.clients.contains(client));
    }




}
