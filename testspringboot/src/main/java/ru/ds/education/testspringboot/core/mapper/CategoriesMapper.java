package ru.ds.education.testspringboot.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.ds.education.testspringboot.core.model.CategoriesDto;
import ru.ds.education.testspringboot.db.entity.Categories;

@Component
public class CategoriesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Categories.class, CategoriesDto.class)
                .byDefault()
                .register();
    }
}
