package com.coopeuch.taskmanager.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coopeuch.taskmanager.models.Tarea;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOCreate;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOResponse;
import com.coopeuch.taskmanager.rest.dtos.TareaDTOUpdate;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Tarea.class, TareaDTOCreate.class);        	
        modelMapper.createTypeMap(Tarea.class, TareaDTOUpdate.class);
        modelMapper.createTypeMap(Tarea.class, TareaDTOResponse.class);

        return modelMapper;
	}
}
