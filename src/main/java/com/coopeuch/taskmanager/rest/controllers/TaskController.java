package com.coopeuch.taskmanager.rest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopeuch.taskmanager.rest.dtos.TareaDTOCreate;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOResponse;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOUpdate;
import com.coopeuch.taskmanager.services.TaskService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/tasks")
@Slf4j
public class TaskController {
	
	private final TaskService _taskService;

	public TaskController(TaskService taskService) {
		this._taskService = taskService;
	}
	
    @PostMapping("Create")
    public ResponseEntity<?> createTask(@Valid @RequestBody TareaDTOCreate tareaCreate) {
		TareaDTOResponse tareaResponse = this._taskService.createTask(tareaCreate);
        return ResponseEntity.ok(tareaResponse);    	   	
    }	
	
    @GetMapping("GetAll")
    public List<TareaDTOResponse> getAllTasks() {
		List<TareaDTOResponse> tareasDto = this._taskService.getAllTasks();
		return tareasDto;
    }

    @PutMapping("Update")
    public ResponseEntity<?> updateTask(@Valid @RequestBody TareaDTOUpdate tareaUpdate) {
        TareaDTOResponse tareaResponse = this._taskService.updateTask(tareaUpdate);
        return ResponseEntity.ok(tareaResponse);
    }

    @DeleteMapping("Remove/{id}")
    public void deleteTask(@PathVariable Integer id) {
        this._taskService.deleteTask(id);
    }

}
