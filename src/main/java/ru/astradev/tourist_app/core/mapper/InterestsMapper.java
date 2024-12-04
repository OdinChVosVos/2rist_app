package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.core.model.InterestsDto;
import ru.astradev.tourist_app.core.model.UsersDto;
import ru.astradev.tourist_app.db.entity.Interests;
import ru.astradev.tourist_app.db.entity.Users;

@Component
public class InterestsMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Interests.class, InterestsDto.class)
                .byDefault()
                .register();
    }
}
