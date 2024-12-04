package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.db.entity.TagsPlaces;

@Component
public class TagsPlacesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(TagsPlaces.class, TagsPlacesMapper.class)
                .byDefault()
                .register();
    }
}
