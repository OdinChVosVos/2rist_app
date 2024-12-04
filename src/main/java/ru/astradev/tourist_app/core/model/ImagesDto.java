package ru.astradev.tourist_app.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImagesDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("Картинка")
    private String image;

    @ApiModelProperty("Место")
    private PlacesDto place;


}