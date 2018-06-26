package com.bs.em.domain;

import javax.persistence.*;

@Entity
@Table(name = "USER_TASK")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "seq_em", sequenceName = "seq_user_task", allocationSize = 1, initialValue = 1)
public class UserTask extends DataTask{
    private String taskDescription;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
