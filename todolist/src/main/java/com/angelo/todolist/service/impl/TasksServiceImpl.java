package com.angelo.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelo.todolist.model.Task;
import com.angelo.todolist.repository.TasksRepository;
import com.angelo.todolist.service.TasksService;

@Service("taskservice")
public class TasksServiceImpl implements TasksService{
	
	@Autowired
	private TasksRepository tasksRepository;

	@Override
	public void saveTask(Task task) {
		tasksRepository.save(task);
	}

	@Override
	public List<Task> getAll() {
		return tasksRepository.findAll();
	}

	@Override
	public List<Task> getDoneTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(long id) {
		tasksRepository.deleteById(id);
	}
	
	
}
