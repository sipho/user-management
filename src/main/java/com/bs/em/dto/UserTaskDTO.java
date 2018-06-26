package com.bs.em.dto;

import com.bs.em.domain.DataTask;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

public class UserTaskDTO implements Serializable {

    private Long id;
    @NotNull
    @JsonProperty("task_description")
    private String taskDescription;
    @NotNull
    @JsonProperty("action_date")
    private LocalDateTime actionDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    @JsonProperty("user_dto")
    private UserDTO userDTO;
    @JsonProperty("status")
    private DataTask.Status status;
    private DataTask.Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public DataTask.Status getStatus() {
        return status;
    }

    public void setStatus(DataTask.Status status) {
        this.status = status;
    }

    public DataTask.Type getType() {
        return type;
    }

    public void setType(DataTask.Type type) {
        this.type = type;
    }
}
