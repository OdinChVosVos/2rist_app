package ru.astradev.tourist_app.api.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.core.model.TagsPlacesDto;
import ru.astradev.tourist_app.core.service.TagsPlacesService;
import ru.astradev.tourist_app.core.service.TagsService;
import ru.astradev.tourist_app.db.entity.TagsPlaces;

import java.util.List;


@RestController
@RequestMapping("/api/tagsPlaces")
public class TagsPlacesController {

    @Autowired
    private TagsPlacesService tagsPlacesService;


    @ApiOperation(
            value = "Добавление записи"
    )
    @PostMapping(value = "/add")
    public TagsPlacesDto add(@RequestBody TagsPlaces tagsPlaces){
        return tagsPlacesService.addTagsPlaces(tagsPlaces);
    }


//    @ApiOperation(
//            value = "Удаление тэга"
//    )
//    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
//    public void remove(@RequestParam String name){
//        tagsService.remove(name);
//    }


    @ApiOperation(
            value = "Получение всех записей"
    )
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<TagsPlacesDto> getAll(){
        return tagsPlacesService.getAll();
    }


    @ApiOperation(
            value = "Получение записей по месту"
    )
    @RequestMapping(value = "/get/place/{name}", method = RequestMethod.GET)
    public List<TagsPlacesDto> getByPlace(@PathVariable String name){
        return tagsPlacesService.getByPlace(name);
    }


}
