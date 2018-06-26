package com.bs.em.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "DATA_TASK")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "seq_em", sequenceName = "seq_data_task", allocationSize = 1, initialValue = 1)
public abstract class DataTask extends AbstractPersistable<Long> {

    public enum Type {
        initiate_user_task,
        terminate_user_task
    }

    public enum Status {
        pending,
        done
    }

    private LocalDateTime actionDate;

    private LocalDateTime endDate;
    //h2 database was not happy for me to use this
    //private User user;

    private Long userId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.pending;

    public DataTask() {
    }

    public DataTask(Type type) {
        this.type = type;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
