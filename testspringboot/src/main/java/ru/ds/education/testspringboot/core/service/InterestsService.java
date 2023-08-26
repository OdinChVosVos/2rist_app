package ru.ds.education.testspringboot.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ds.education.testspringboot.core.mapper.InterestsMapper;
import ru.ds.education.testspringboot.core.mapper.TagsMapper;
import ru.ds.education.testspringboot.core.model.InterestsDto;
import ru.ds.education.testspringboot.core.model.TagsDto;
import ru.ds.education.testspringboot.db.entity.Interests;
import ru.ds.education.testspringboot.db.repository.InterestsRepository;
import ru.ds.education.testspringboot.db.repository.TagsRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class InterestsService {

    @Autowired
    private InterestsRepository interestsRepository;

    @Autowired
    private InterestsMapper interestsMapper;

    public void remove(String mail){
        interestsRepository.remove(mail);
    }

    public InterestsDto add(Interests interest){
        interestsRepository.add(interest.getUser().getId(), interest.getTag().getId(), interest.getCoeff());
        return interestsMapper.map(interestsRepository.getByUser(interest.getUser().getMail()), InterestsDto.class);
    }

    public List<InterestsDto> getAll(){
        return interestsMapper.mapAsList(interestsRepository.findAll(), InterestsDto.class);
    }

    public List<InterestsDto> getByUser(String mail){
        return interestsMapper.mapAsList(interestsRepository.getByUser(mail), InterestsDto.class);
    }

}
