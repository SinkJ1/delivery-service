package dao;

import dto.entity.ClientDto;
import entity.Client;
import mapper.ClientMapper;

import java.util.List;

public class ClientRepositoryImpl extends BaseDao<Client, ClientDto, Long> implements ClientRepository {

    public ClientRepositoryImpl(String path) {
        super(path, new ClientMapper());
    }

    @Override
    protected Class<ClientDto[]> getDClass() {
        return ClientDto[].class;
    }

    @Override
    protected Client getById(Long id, List<Client> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(Client entity) {
        List<Client> clients = readAll();
        List<ClientDto> dtoList;

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equals(entity.getId())) {
                clients.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(clients);
        write(dtoList);
    }

}
