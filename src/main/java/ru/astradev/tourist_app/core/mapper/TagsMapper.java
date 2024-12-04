package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.core.model.PlacesDto;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.db.entity.Places;
import ru.astradev.tourist_app.db.entity.Tags;

@Component
public class TagsMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Tags.class, TagsDto.class)
                .byDefault()
                .register();
    }
}
