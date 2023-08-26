package ru.ds.education.testspringboot.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.testspringboot.db.entity.TagsPlaces;

@Component
public class TagsPlacesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(TagsPlaces.class, TagsPlacesMapper.class)
                .byDefault()
                .register();
    }
}
