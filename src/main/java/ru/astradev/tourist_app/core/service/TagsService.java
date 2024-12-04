package ru.astradev.tourist_app.core.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.astradev.tourist_app.core.mapper.TagsMapper;
import ru.astradev.tourist_app.core.model.TagsDto;
import ru.astradev.tourist_app.db.repository.TagsRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private TagsMapper tagsMapper;


    public List<TagsDto> addTags(List<String> tags){
        List<TagsDto> newTags = new ArrayList<>();

        for (String tag:tags) {
            tagsRepository.add(tag);
            newTags.add(tagsMapper.map(tagsRepository.getTagByName(tag), TagsDto.class));
        }
        return newTags;
    }

    public void remove(String name){
        try{
            tagsRepository.remove(name);
        }
        catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public List<TagsDto> getAll(){
        return tagsMapper.mapAsList(tagsRepository.findAll(), TagsDto.class);
    }

    public TagsDto getByName(String name){
        return tagsMapper.map(tagsRepository.getByName(name), TagsDto.class);
    }

    public List<TagsDto> getByPlace(String name){
        return tagsMapper.mapAsList(tagsRepository.getByPlace(name), TagsDto.class);
    }

}
