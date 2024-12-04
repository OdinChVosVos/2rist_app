package ru.astradev.tourist_app.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InterestsDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("Пользователь")
    private UsersDto user;

    @ApiModelProperty("Категория")
    private CategoriesDto category;

    @ApiModelProperty("Коэффициент")
    private float coeff;

}
