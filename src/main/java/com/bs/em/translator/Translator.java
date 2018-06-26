package com.bs.em.translator;

import com.bs.em.domain.User;
import com.bs.em.dto.UserTaskDTO;
import com.bs.em.dto.UserDTO;
import com.bs.em.domain.UserTask;

import java.time.ZoneOffset;

public class Translator {

    //user
    public User toUser(UserDTO dto){
        User user = new User();
        setUser(dto, user);
        return user;
    }

    public User toUser(User emp, UserDTO dto){
        setUser(dto, emp);
        return emp;
    }

    private void setUser(UserDTO dto, User user) {
        user.setIdNo(dto.getIdNo());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setIdNo(dto.getIdNo());
        user.setRace(dto.getRace());
        user.setUsername(dto.getUsername());
        user.setMobileNumber(dto.getMobileNumber());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
    }

    public UserDTO toUserDTO(User emp){
        UserDTO dto = new UserDTO();
        if (emp != null){
            dto.setEmail(emp.getEmail());
            dto.setFirstName(emp.getFirstName());
            dto.setIdNo(emp.getIdNo());
            dto.setId(emp.getId());
            dto.setRace(emp.getRace());
            dto.setMobileNumber(emp.getMobileNumber());
            dto.setLastName(emp.getLastName());
            dto.setUsername(emp.getUsername());
        }
        return dto;
    }


    //task
    public UserTask toDataTask(UserTaskDTO dto){
        UserTask task = new UserTask();
        setTask(dto, task);
        return task;
    }

    public UserTask toDataTask(UserTask task, UserTaskDTO dto){
        setTask(dto, task);
        return task;
    }

    private void setTask(UserTaskDTO dto, UserTask task) {
        task.setType(dto.getType());
        task.setTaskDescription(dto.getTaskDescription());
        task.setActionDate(dto.getActionDate());
        task.setStatus(dto.getStatus());
    }

    public UserTaskDTO toDataTaskDTO(UserTask task){
        UserTaskDTO dto = new UserTaskDTO();
        dto.setActionDate(task.getActionDate());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setStatus(task.getStatus());
        dto.setType(task.getType());
        dto.setId(task.getId());
        return dto;
    }
}
