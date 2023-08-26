package ru.ds.education.testspringboot.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriesDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("Название")
    private String name;

}
