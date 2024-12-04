package ru.astradev.tourist_app.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astradev.tourist_app.db.entity.Role;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsersDto {

    @ApiModelProperty("id пользователя")
    private Long id;

    @ApiModelProperty("Почта")
    private String mail;

    @ApiModelProperty("Пароль пользователя")
    private String password;

    @ApiModelProperty("Номер телефона")
    private String phone;

    @ApiModelProperty("Имя пользователя")
    private String firstname;

    @ApiModelProperty("Фамилия пользователя")
    private String lastname;

    @ApiModelProperty("Логин пользователя")
    private String login;

    @ApiModelProperty("Роль пользователя")
    private Role role;


}
