package com.angelo.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angelo.todolist.model.Task;
import com.angelo.todolist.service.TasksService;

@Controller
public class TasksController {
	
	@Autowired
	private TasksService tasksService;
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Task> taskList = tasksService.getAll();
		mv.addObject("taskList", taskList);
		return mv;
	}
}
