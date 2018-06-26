package com.bs.em.service;

import com.bs.em.ApplicationException;
import com.bs.em.domain.User;
import com.bs.em.dto.UserDTO;
import com.bs.em.repository.UserRepository;
import com.bs.em.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    private Translator translator = new Translator();

    @Transactional
    public UserDTO create(UserDTO dto){
        User user = userRepo.findByIdNo(dto.getIdNo());
        if (user != null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_ALREADY_EXIST, "User already exist");
        }
        return translator.toUserDTO(
                userRepo.save(translator.toUser(dto))
        );
    }

    @Transactional
    public UserDTO update(UserDTO dto, Long id){
        User user = userRepo.findByIdNo(id);
        if (user == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_NOT_FOUND, "User not found while attempting to update");
        }

        return translator.toUserDTO(
                userRepo.save(translator.toUser(user, dto))
        );
    }

    @Transactional
    public UserDTO search(Long id){
        User user = userRepo.findByIdNo(id);
        if (user == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_NOT_FOUND, "User not found");
        }
        return translator.toUserDTO(
                user
        );
    }

    @Transactional
    public List<UserDTO> findAllUsers(){
        List<User> listOfUsers = userRepo.findAll();
        List<UserDTO> listOfUserDTO = new ArrayList<>();
        listOfUsers.forEach(user -> {
            listOfUserDTO.add(translator.toUserDTO(user));
        });
        return listOfUserDTO;
    }
}
