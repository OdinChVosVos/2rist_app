package ru.ds.education.testspringboot.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.testspringboot.core.model.PlacesDto;
import ru.ds.education.testspringboot.db.entity.Places;

@Component
public class PlacesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Places.class, PlacesDto.class)
                .byDefault()
                .register();
    }
}
