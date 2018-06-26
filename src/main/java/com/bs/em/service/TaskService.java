package com.bs.em.service;

import com.bs.em.ApplicationException;
import com.bs.em.domain.DataTask;
import com.bs.em.domain.User;
import com.bs.em.domain.UserTask;
import com.bs.em.dto.UserTaskDTO;
import com.bs.em.repository.TaskRepository;
import com.bs.em.repository.UserRepository;
import com.bs.em.translator.Translator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;
    @Autowired
    private UserRepository userRepo;

    private Translator translator = new Translator();

    private static Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Transactional
    public UserTaskDTO create(UserTaskDTO dto, Long userId){
        User user = userRepo.findByIdNo(userId);
        if (user == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_NOT_FOUND, "User not found while creating a task");
        }
        UserTask userTask = translator.toDataTask(dto);
        userTask.setUserId(userId);
        UserTaskDTO userTaskDTO = translator.toDataTaskDTO(
                taskRepo.save(userTask)
        );
        userTaskDTO.setUserDTO(translator.toUserDTO(user));
        return userTaskDTO;
    }

    @Transactional
    public UserTaskDTO update(UserTaskDTO dto, Long userId, Long taskId){

        User user = userRepo.findByIdNo(userId);
        UserTask userTask = (UserTask) taskRepo.findOne(taskId);
        if (userTask == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_TASK_NOT_FOUND, "Task not found while attempting to update");
        }

        if (user == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_NOT_FOUND, "User not found while updating a task");
        }

         UserTaskDTO userTaskDTO = translator.toDataTaskDTO(
                taskRepo.save(translator.toDataTask(userTask, dto))
        );
        userTaskDTO.setUserDTO(translator.toUserDTO(user));
        return userTaskDTO;
    }

    @Transactional
    public UserTaskDTO search(Long userId, Long taskId){
        User user = userRepo.findByIdNo(userId);
        if (user == null){
            throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_NOT_FOUND, "User not found while updating a task");
        }

        DataTask dataTask = taskRepo.findOne(taskId);
        if (dataTask != null && dataTask.getType().equals(DataTask.Type.initiate_user_task)){
            if (!userId.equals(dataTask.getUserId())){
                throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_INVALID_ID, "Invalid user id");
            }
            UserTaskDTO task = translator.toDataTaskDTO((UserTask) dataTask);
            task.setUserDTO(translator.toUserDTO(user));
            return task;
        } else {
            return new UserTaskDTO();
        }
    }

    @Transactional
    public List<UserTaskDTO> findAllByUser(Long userId){
        List<UserTaskDTO> listOfUserTaskDTO = new ArrayList<>();
        User user = userRepo.findByIdNo(userId);
        if (user == null) {
            return new ArrayList<>();
        }
        List<DataTask> listOfTask = taskRepo.findByUserId(userId);

        listOfTask.forEach(dataTask -> {
            if (dataTask.getType().equals(DataTask.Type.initiate_user_task)) {
                UserTaskDTO task = translator.toDataTaskDTO((UserTask) dataTask);
                task.setUserDTO(translator.toUserDTO(user));
                listOfUserTaskDTO.add(task);
            }
        });
        return listOfUserTaskDTO;
    }

    @Transactional
    public void delete(Long taskId, Long userId){
        DataTask dataTask = taskRepo.findOne(taskId);
        if (dataTask != null && dataTask.getType().equals(DataTask.Type.initiate_user_task)){
            if (!userId.equals(dataTask.getUserId())){
                throw new ApplicationException(ApplicationException.Type.client_error, ApplicationException.CODE_USER_INVALID_ID, "Invalid user id");
            }
            taskRepo.delete(dataTask);
        }
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 30000)  // every 5 seconds, 30 second initial delay
    public void checkDataTasks() {
        processTasks();
    }

    protected void processTasks() {
        List<DataTask> tasks = taskRepo.findByStatusEqualsAndActionDateLessThan(DataTask.Status.pending, LocalDateTime.now());
        for (DataTask task : tasks) {
            task.setStatus(DataTask.Status.done);
            UserTask uTask = (UserTask)taskRepo.save(task);

            logger.info("Task completed, userId: " + uTask.getUserId() + ", taskDescription: " + uTask.getTaskDescription());
        }
    }
}