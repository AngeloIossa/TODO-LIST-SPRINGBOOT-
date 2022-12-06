package com.angelo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelo.todolist.model.Task;

public interface TasksRepository extends JpaRepository<Task, Long>{

}
