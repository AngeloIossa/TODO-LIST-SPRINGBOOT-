package com.angelo.todolist.service;

import java.util.List;

import com.angelo.todolist.model.Task;

public interface TasksService {
	void saveTask(Task task);
	List<Task> getAll();
	List<Task> getDoneTasks();
	List<Task> getTasks();
	void deleteTask(long id);
	
}
