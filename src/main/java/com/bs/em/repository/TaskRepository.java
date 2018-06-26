package com.bs.em.repository;

import com.bs.em.domain.DataTask;
import com.bs.em.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<DataTask, Long>, JpaSpecificationExecutor<DataTask>{
    List<DataTask> findByUserId(Long userId);
    List<DataTask> findByStatusEqualsAndActionDateLessThan(DataTask.Status status, LocalDateTime actionDate);

}
