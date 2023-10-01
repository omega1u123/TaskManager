package com.example.demo.store.repo;

import com.example.demo.store.entity.TaskEntity;
import com.example.demo.store.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
    public List<TaskEntity> findAllByUserEntity(UserEntity user);
}
