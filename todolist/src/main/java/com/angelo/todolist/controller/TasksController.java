package com.angelo.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		mv.addObject("task", new Task());
		return mv;
	} 
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView saveTask(Task task) {
		task.setStatus(true);
		System.out.println("Debug: " + task.getTask());
		tasksService.saveTask(task);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/savetask/{sourceText}", method = RequestMethod.GET)
	public ModelAndView saveTask1(@RequestParam String sourceText) {
		Task taskSwap = new Task();
		taskSwap.setTask(sourceText);
		taskSwap.setStatus(true);
		System.out.println("Debug: " + taskSwap.getTask());
		tasksService.saveTask(taskSwap);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView cancellaImpiegato(@PathVariable long id) {
		System.out.println("DelteID: " + id);
		tasksService.deleteTask(id);
		return new ModelAndView("redirect:/");
	}
}
