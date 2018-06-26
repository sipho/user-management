package com.bs.em.controller;

import com.bs.em.dto.UserDTO;
import com.bs.em.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${em.app.api-prefix}/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Validated @RequestBody UserDTO dto){
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO update(@Validated @RequestBody UserDTO dto, @PathVariable(name = "id") Long id){
        return userService.update(dto, id);
    }

    @GetMapping("/{id}")
    public UserDTO search(@PathVariable(name = "id") Long id){
        return userService.search(id);
    }

    @GetMapping()
    public List<UserDTO> findAll(){
        return userService.findAllUsers();
    }
}