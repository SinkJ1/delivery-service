package mapper;

import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

public abstract class BaseMapper<T, Y> {

    ModelMapper mapper;

    protected BaseMapper() {
        this.mapper = new ModelMapper();
    }

    protected abstract List<Long> getIdes();

    protected abstract Class<T> getTClass();

    protected abstract Class<Y> getYClass();

    protected abstract List<ExpressionMap<T, Y>> getExpressionMap();

    public ModelMapper map() {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        for (ExpressionMap<T, Y> expression : getExpressionMap()) {
            mapper.typeMap(getTClass(), getYClass())
                    .addMappings(expression);
        }

        return mapper;
    }

}
