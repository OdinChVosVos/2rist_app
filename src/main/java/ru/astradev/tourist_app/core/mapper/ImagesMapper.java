package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.core.model.ImagesDto;

import ru.astradev.tourist_app.db.entity.Images;


@Component
public class ImagesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Images.class, ImagesDto.class)
                .byDefault()
                .register();
    }
}