package com.coopeuch.taskmanager.rest.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public abstract class TareaDTO {
	
	@NotNull (message = "El campo descripcion no debe ser nulo.")
	@NotEmpty (message = "El campo descripcion no debe estar vacío.")
	private String descripcion;
	
	public TareaDTO() {
		this.descripcion = "";
	}	
	
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
