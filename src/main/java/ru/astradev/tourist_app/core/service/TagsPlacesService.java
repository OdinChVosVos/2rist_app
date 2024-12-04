package ru.astradev.tourist_app.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.astradev.tourist_app.core.mapper.TagsMapper;
import ru.astradev.tourist_app.core.mapper.TagsPlacesMapper;
import ru.astradev.tourist_app.core.model.InterestsDto;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.core.model.TagsPlacesDto;
import ru.astradev.tourist_app.db.entity.TagsPlaces;
import ru.astradev.tourist_app.db.repository.TagsPlacesRepository;

import java.util.List;


@Service
public class TagsPlacesService {

    @Autowired
    private TagsPlacesRepository tagsPlacesRepository;

    @Autowired
    private TagsPlacesMapper tagsPlacesMapper;

    public TagsPlacesDto addTagsPlaces(TagsPlaces tagsPlace){
        tagsPlacesRepository.add(tagsPlace.getPlace().getId(), tagsPlace.getTag().getId());
        return tagsPlacesMapper.map(tagsPlacesRepository.getByPlace(tagsPlace.getPlace().getName()), TagsPlacesDto.class);
    }

//    public void remove(String name){
//        try{
//            tagsRepository.remove(name);
//        }
//        catch (RuntimeException e){
//            System.out.println(e);
//        }
//    }
//
    public List<TagsPlacesDto> getAll(){
        return tagsPlacesMapper.mapAsList(tagsPlacesRepository.findAll(), TagsPlacesDto.class);
    }

    public List<TagsPlacesDto> getByPlace(String name){
        return tagsPlacesMapper.mapAsList(tagsPlacesRepository.getByPlace(name), TagsPlacesDto.class);
    }

}
