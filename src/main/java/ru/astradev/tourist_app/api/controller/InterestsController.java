package ru.astradev.tourist_app.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.astradev.tourist_app.core.model.InterestsDto;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.core.service.InterestsService;
import ru.astradev.tourist_app.core.service.TagsService;
import ru.astradev.tourist_app.db.entity.Interests;

import java.util.List;


@RestController
@RequestMapping("/api/interests")
public class InterestsController {

    @Autowired
    private InterestsService interestsService;


    @ApiOperation(
            value = "Добавление интересов"
    )
    @PostMapping(value = "/add")
    public InterestsDto add(@RequestBody Interests interest){
        return interestsService.add(interest);
    }

    @ApiOperation(
            value = "Удаление интересов"
    )
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestParam String mail){
        interestsService.remove(mail);
    }

    @ApiOperation(
            value = "Получение всех интересов"
    )
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<InterestsDto> getAll(){
        return interestsService.getAll();
    }


    @ApiOperation(
            value = "Получение интересов по пользователю"
    )
    @RequestMapping(value = "/get/{mail}", method = RequestMethod.GET)
    public List<InterestsDto> getByUser(@PathVariable String mail){
        return interestsService.getByUser(mail);
    }


}
