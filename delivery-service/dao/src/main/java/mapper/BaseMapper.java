package mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Objects;

public abstract class BaseMapper<E, D>{

    ModelMapper mapper;

    abstract void mapSpecificFieldsEntity(E source, D destination);
    abstract void mapSpecificFieldsDto(D source, E destination);

    private Class<E> entityClass;
    private Class<D> dtoClass;

    BaseMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFieldsEntity(source, destination);
            return context.getDestination();
        };
    }

    Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFieldsDto(source, destination);
            return context.getDestination();
        };
    }




}
