package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.core.model.UsersDto;
import ru.astradev.tourist_app.db.entity.Users;

@Component
public class UsersMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Users.class, UsersDto.class)
                .byDefault()
                .register();
    }
}
