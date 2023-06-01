package com.coopeuch.taskmanager.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.coopeuch.taskmanager.models.Tarea;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOCreate;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOResponse;
import com.coopeuch.taskmanager.rest.repositories.TaskRepository;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	
	private TaskService _taskService;

    @Mock
    private TaskRepository _taskRepository;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        _taskService = new TaskServiceImpl(_taskRepository,new ModelMapper());        
    }
	
    @DisplayName("Dado una tarea que queremos registrar, " +
    			 "cuando invocamos a createTask, " +
    			"esperamos que la tarea esté creada como vigente")
	@Test
	public void test1() {
		
		Tarea t_simulada = new Tarea();
		t_simulada.setIdentificador(1);
		t_simulada.setDescripcion("Prueba 1 - Tarea Creación");
		t_simulada.setVigente(true);
		
		TareaDTOResponse tareaEsperada = new TareaDTOResponse();
		tareaEsperada.setIdentificador(1);
		tareaEsperada.setDescripcion("Prueba 1 - Tarea Creación");
		tareaEsperada.setVigente(true);

		TareaDTOCreate tareaDto = new TareaDTOCreate();
		tareaDto.setDescripcion("Prueba 1 - Tarea Creación");
		
		Mockito.when(_taskRepository.save(Mockito.any(Tarea.class)))
				.thenReturn(t_simulada);

        // Realizar la prueba con el servicio
        TareaDTOResponse resultado = _taskService.createTask(tareaDto);

        // Verificar que el resultado sea el esperado
        Assertions.assertEquals(tareaEsperada.getDescripcion(), resultado.getDescripcion(), "message: Distintas descripciones");
        Assertions.assertEquals(tareaEsperada.isVigente(), resultado.isVigente(), "message: La tarea quedó No Vigente");		
	}     
}
