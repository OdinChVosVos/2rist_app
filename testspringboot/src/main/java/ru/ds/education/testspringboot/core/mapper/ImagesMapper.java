package ru.ds.education.testspringboot.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.testspringboot.core.model.ImagesDto;

import ru.ds.education.testspringboot.db.entity.Images;


@Component
public class ImagesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Images.class, ImagesDto.class)
                .byDefault()
                .register();
    }
}