package ru.astradev.tourist_app.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ru.astradev.tourist_app.core.model.UsersDto;
import ru.astradev.tourist_app.core.service.UsersService;


import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("demo");
    }

    @ApiOperation(
            value = "Удаление пользователя по почте"
    )
    @RequestMapping(value = "/remove/{mail}", method = RequestMethod.DELETE)
    public void removeByMail(@PathVariable String mail){
        usersService.removeByMail(mail);
    }

    @ApiOperation(
            value = "Изменение пользователя"
    )
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public UsersDto updateUser(@RequestBody UsersDto user){
        return usersService.updateUser(user);
    }

//    @ApiOperation(
//            value = "Добавление пользователя"
//    )
//    @PostMapping
//    public UsersDto signUp(@RequestBody UsersDto user){
//        return usersService.signUp(user);
//    }

    @ApiOperation(
            value = "Получение всех пользователей"
    )
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<UsersDto> getAll(){
        return usersService.getAll();
    }


    @ApiOperation(
            value = "Получение пользователя по почте"
    )
    @RequestMapping(value = "/get/{mail}", method = RequestMethod.GET)
    public UsersDto getByMail(@PathVariable String mail){
        return usersService.getByMail(mail);
    }
}
