package ru.astradev.tourist_app.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TagsPlacesDto {

    @ApiModelProperty("id связи")
    private Long id;

    @ApiModelProperty("Место")
    private PlacesDto place;

    @ApiModelProperty("Тэг")
    private TagsDto tag;

}