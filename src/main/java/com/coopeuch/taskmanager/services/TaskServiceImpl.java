package com.coopeuch.taskmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.coopeuch.taskmanager.models.Tarea;
import com.coopeuch.taskmanager.rest.controllers.TaskController;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOCreate;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOResponse;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOUpdate;
import com.coopeuch.taskmanager.rest.repositories.TaskRepository;

import jakarta.persistence.PersistenceException;

@Service
public class TaskServiceImpl implements TaskService {
	
	private final Logger _logger = LoggerFactory.getLogger(TaskController.class);	
    private final TaskRepository _taskRepository;
    private final ModelMapper _modelMapper;
    
    public TaskServiceImpl(TaskRepository tareaRepository, ModelMapper modelMapper) {
        this._taskRepository = tareaRepository;
        this._modelMapper = modelMapper;
    }

    @Override
    public TareaDTOResponse createTask(TareaDTOCreate tareaCreate) {
    	try {
    		Tarea tarea = this._modelMapper.map(tareaCreate, Tarea.class);
    		tarea.setDescripcion(tareaCreate.getDescripcion());
    		Tarea nuevaTarea = this._taskRepository.save(tarea);    		
    		TareaDTOResponse tareaResponse = this._modelMapper.map(nuevaTarea, TareaDTOResponse.class);
            return tareaResponse;
    	}catch(Exception e) {
    		_logger.error("createTask - ",e);
    		return null;
    	} 
    }

    @Override
    public TareaDTOResponse updateTask(TareaDTOUpdate tareaUpdate) {
    	Integer id = tareaUpdate.getIdentificador();
        Tarea tarea = _taskRepository.findById(id)
                .orElse(null);
        try {
            tarea.setDescripcion(tareaUpdate.getDescripcion());
            tarea.setVigente(tareaUpdate.isVigente());
            TareaDTOResponse tareaResponse = _modelMapper
            					.map(_taskRepository.save(tarea), TareaDTOResponse.class);
            
            return tareaResponse;
        }
        catch(NullPointerException nexp) {
        	_logger.info("updateTask - No se encotró la tarea");
    		TareaDTOResponse t = new TareaDTOResponse();
    		t.setDescripcion(nexp.getMessage());
        	return t;
        }
        catch(MappingException mexp) {
        	_logger.error("updateTask - Error en mapeo: ", mexp);
        	return null;
        }
        catch(PersistenceException pex) {
        	_logger.error("updateTask - Error en persistencia de datos: ", pex);
        	return null;        	
        }
    }

    @Override
    public void deleteTask(int id) {
        if (!_taskRepository.existsById(id)) {
            throw new NotFoundException("Tarea no encontrada");
        }
        _taskRepository.deleteById(id);
    }

    @Override
    public List<TareaDTOResponse> getAllTasks() {
    	try {
    		List<Tarea> tareas = _taskRepository
    				.findAll(Sort.by(Sort.Direction.ASC,"descripcion"));
    		List<TareaDTOResponse> tareasDto = tareas.stream()
    					.map(tarea -> _modelMapper.map(tarea,TareaDTOResponse.class))
    					.collect(Collectors.toList());
    		return tareasDto;
    	}catch(Exception e) {
    		_logger.error("getAllTasks - ",e);
    		return null;
    	}
    }
    
    @Override
    public TareaDTOResponse getTaskById(int id) {
        Tarea tarea = _taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tarea no encontrada"));
        return _modelMapper.map(tarea, TareaDTOResponse.class);    	
    }
}
