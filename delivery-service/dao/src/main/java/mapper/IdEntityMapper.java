package mapper;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IdEntityMapper<T> {

    public List<Long> getId(List<T> entities, Function<T,Long> function){
        return entities.stream().map(function).collect(Collectors.toList());
    }

    public T toEntity(List<T> entities, Predicate<T> predicate){
        return entities.stream().filter(predicate).findFirst().get();
    }

}
