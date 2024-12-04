package ru.astradev.tourist_app.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlacesDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("Категория")
    private CategoriesDto category;

    @ApiModelProperty("Название")
    private String name;

    @ApiModelProperty("Ссылка")
    private String url;

    @ApiModelProperty("Адрес")
    private String adress;

    @ApiModelProperty("Время работы")
    private String time_work;

    @ApiModelProperty("Координаты")
    private String position;

}
