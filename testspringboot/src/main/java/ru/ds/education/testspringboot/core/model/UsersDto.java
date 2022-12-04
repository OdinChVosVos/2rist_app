package ru.ds.education.testspringboot.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {

    @ApiModelProperty("id пользователя")
    private Long id;

    @ApiModelProperty("telegram id пользователя")
    private Long id_telegram;

    @ApiModelProperty("Логин пользователя")
    private String name;

    @ApiModelProperty("Имя пользователя")
    private String firstname;

    @ApiModelProperty("Фамилия пользователя")
    private String lastname;

    @ApiModelProperty("Номер телефона")
    private String phone;

    @ApiModelProperty("Почта")
    private String mail;

    @ApiModelProperty("Соглашение на получение оповещений")
    private boolean agreement;

}
