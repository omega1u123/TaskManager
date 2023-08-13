package com.example.demo.store.repo;

import com.example.demo.store.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
}
