package com.coopeuch.taskmanager.services;

import java.util.List;

import com.coopeuch.taskmanager.rest.dtos.TareaDTOCreate;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOResponse;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOUpdate;

public interface TaskService {
    TareaDTOResponse createTask(TareaDTOCreate tareaCreate);
    TareaDTOResponse updateTask(TareaDTOUpdate tareaUpdate);
    void deleteTask(int id);
    List<TareaDTOResponse> getAllTasks();
    TareaDTOResponse getTaskById(int id);
}
