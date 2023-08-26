package ru.ds.education.testspringboot.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.testspringboot.core.model.PlacesDto;
import ru.ds.education.testspringboot.core.model.TagsDto;
import ru.ds.education.testspringboot.db.entity.Places;
import ru.ds.education.testspringboot.db.entity.Tags;

@Component
public class TagsMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Tags.class, TagsDto.class)
                .byDefault()
                .register();
    }
}
