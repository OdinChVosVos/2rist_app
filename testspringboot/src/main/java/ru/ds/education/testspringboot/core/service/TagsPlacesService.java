package ru.ds.education.testspringboot.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ds.education.testspringboot.core.mapper.TagsMapper;
import ru.ds.education.testspringboot.core.mapper.TagsPlacesMapper;
import ru.ds.education.testspringboot.core.model.InterestsDto;
import ru.ds.education.testspringboot.core.model.TagsDto;
import ru.ds.education.testspringboot.core.model.TagsPlacesDto;
import ru.ds.education.testspringboot.db.entity.TagsPlaces;
import ru.ds.education.testspringboot.db.repository.TagsPlacesRepository;

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
