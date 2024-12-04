package ru.astradev.tourist_app.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.core.model.UsersDto;
import ru.astradev.tourist_app.core.service.TagsService;
import ru.astradev.tourist_app.core.service.UsersService;

import java.util.List;


@RestController
@RequestMapping("/api/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;


    @ApiOperation(
            value = "Добавление тэга"
    )
    @PostMapping(value = "/add")
    public List<TagsDto> addTags(@RequestBody List<String> tags){
        return tagsService.addTags(tags);
    }


    @ApiOperation(
            value = "Удаление тэга"
    )
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestParam String name){
        tagsService.remove(name);
    }


    @ApiOperation(
            value = "Получение всех тэгов"
    )
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<TagsDto> getAll(){
        return tagsService.getAll();
    }


    @ApiOperation(
            value = "Получение тэга по названию"
    )
    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public TagsDto getTag(@PathVariable String name){
        return tagsService.getByName(name);
    }


    @ApiOperation(
            value = "Получение тэгов по месту"
    )
    @RequestMapping(value = "/get/place/{name}", method = RequestMethod.GET)
    public List<TagsDto> getByPlace(@PathVariable String name){
        return tagsService.getByPlace(name);
    }


}
