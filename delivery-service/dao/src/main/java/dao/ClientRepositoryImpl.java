package dao;

import entity.Client;

import java.util.List;

public class ClientRepositoryImpl extends BaseDao<Client, Long> implements Repository<Client, Long> {

    public ClientRepositoryImpl(String path, List<Client> clients) {
        super(path, clients);
    }

    @Override
    public Class<Client[]> getTClass() {
        return Client[].class;
    }

    @Override
    protected Client getById(Long id, List<Client> entities) {
        for(Client client: entities){
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }

    @Override
    public void update(Client entity){

        for(int i = 0; i < entities.size(); i++){
            if(entities.get(i).getId() == entity.getId()){
                entities.set(i,entity);
            }
        }

    }

}
