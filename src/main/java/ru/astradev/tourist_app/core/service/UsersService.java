package ru.astradev.tourist_app.core.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.astradev.tourist_app.api.job.NullProperties;
import ru.astradev.tourist_app.core.model.UsersDto;

import ru.astradev.tourist_app.core.mapper.UsersMapper;
import ru.astradev.tourist_app.db.entity.Users;
import ru.astradev.tourist_app.db.repository.UsersRepository;


import java.util.List;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;


//    public UsersDto signUp(UsersDto user){
//        usersRepository.add(
//                user.getMail(), user.getPassword(),
//                true,
////                passwordEncoder().encode(user.getPassword()),
//                user.getPhone(), user.getFirstname(),
//                user.getLastname(), user.getLogin()
//        );
//        UsersDto newUser = usersMapper.map(usersRepository.getByMail(user.getMail()), UsersDto.class);
//        usersRolesRepository.add(newUser.getId(), 1L);
//
//        return newUser;
//    }
//
//    public UsersDto signUpAdmin(UsersDto user, Long role_id){
//        usersRepository.add(
//                user.getMail(), user.getPassword(),
//                true,
////                passwordEncoder().encode(user.getPassword()),
//                user.getPhone(), user.getFirstname(),
//                user.getLastname(), user.getLogin()
//        );
//        UsersDto newUser = usersMapper.map(usersRepository.getByMail(user.getMail()), UsersDto.class);
//        usersRolesRepository.add(newUser.getId(), role_id);
//
//        return newUser;
//    }

    public void removeByMail(String mail){
        try{
            if (mail.equals("Admin")) return;
            usersRepository.delete(getByMail(mail).getId());
        }
        catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public void delete(Long id){
        try{
            if (id == 0) return;
            usersRepository.delete(id);
        }
        catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public UsersDto updateUser(UsersDto user){
        Users existingUser = usersRepository.getByMail(user.getMail());
        BeanUtils.copyProperties(user, existingUser, NullProperties.getNullPropertyNames(user));
        return usersMapper.map(usersRepository.saveAndFlush(existingUser), UsersDto.class);
    }

    public List<UsersDto> getAll(){
        return usersMapper.mapAsList(usersRepository.findAll(), UsersDto.class);
    }

    public UsersDto getByMail(String mail){
        return usersMapper.map(usersRepository.getByMail(mail), UsersDto.class);
    }

//    public boolean checkUsr(UsersDto user){
//        return getByName(user.getName())!=null && Objects.equals(getByName(user.getName()).getPassword(), user.getPassword());
//    }

}
