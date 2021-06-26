package mapper;

import dto.entity.ClientDto;
import entity.Client;

public class ClientMapper extends BaseMapper<Client, ClientDto> {
    ClientMapper(Class<Client> entityClass, Class<ClientDto> dtoClass) {
        super(entityClass, dtoClass);
    }

    @Override
    void mapSpecificFieldsEntity(Client source, ClientDto destination) {

    }

    @Override
    void mapSpecificFieldsDto(ClientDto source, Client destination) {

    }
}
