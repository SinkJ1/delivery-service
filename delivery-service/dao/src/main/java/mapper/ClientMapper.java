package mapper;

import dto.entity.ClientDto;
import entity.Client;

public class ClientMapper extends BaseMapper<Client, ClientDto> {
    public ClientMapper() {
        super(Client.class, ClientDto.class);
    }

    @Override
    void mapSpecificFieldsEntity(Client source, ClientDto destination) {

    }

    @Override
    void mapSpecificFieldsDto(ClientDto source, Client destination) {

    }
}
