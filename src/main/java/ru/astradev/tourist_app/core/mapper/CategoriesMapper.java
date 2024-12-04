package ru.astradev.tourist_app.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import ru.astradev.tourist_app.core.model.CategoriesDto;
import ru.astradev.tourist_app.db.entity.Categories;

@Component
public class CategoriesMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Categories.class, CategoriesDto.class)
                .byDefault()
                .register();
    }
}
