package dao;

import entity.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientRepositoryTest {

    private final String clientPath = "src/test/resources/data/client.json";

    BaseRepository<Client, Long> clientRepository = new ClientRepositoryImpl(clientPath);
    Client client = new Client(5L, "name", "Brest");

    @Test
    public void createClient() {
        clientRepository.create(client);
        Client client1 = clientRepository.read(client.getId());
        Assert.assertEquals(client, client1);

    }

    @Test
    public void updateClient() {
        Client client1 = clientRepository.readAll().get(0);
        client1.setName("new name");
        clientRepository.update(client1);
        Client client2 = clientRepository.readAll().get(0);
        Assert.assertEquals(client1, client2);
    }


    @Test
    public void deleteClient() {
        clientRepository.delete(client);
        Assert.assertFalse(clientRepository.readAll().contains(client));
    }

}
