package com.alohatech.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alohatech.exception.ResourceNotFoundException;
import com.alohatech.model.Task;
import com.alohatech.repository.TaskRepository;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	

	@GetMapping("/task")
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}		
	
	
	@PostMapping("/task")
	public Task createTask(@RequestBody Task t) {
		return taskRepository.save(t);
	}
	
	
	@GetMapping("/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		Task t = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id :" + id));
		return ResponseEntity.ok(t);
	}
	
	
	
	@PutMapping("/task/{id}")
	public ResponseEntity<Task> updateEmployee(@PathVariable Long id, @RequestBody Task t){
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id :" + id));
		
		task.setTitle(t.getTitle());
		task.setDescription(t.getDescription());
		
		Task updatedTask = taskRepository.save(task);
		return ResponseEntity.ok(updatedTask);
	}
	
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Task t = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not exist with id :" + id));
		
		taskRepository.delete(t);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
