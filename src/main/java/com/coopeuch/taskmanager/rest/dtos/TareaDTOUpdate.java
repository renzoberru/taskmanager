package com.coopeuch.taskmanager.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;


public class TareaDTOUpdate extends TareaDTO {
	
	@NotNull (message = "El campo identificador no debe ser nulo")
	@Min (value = 1, message = "El campo identificador debe ser un valor mayor que 0")
	private Integer identificador;
	
	@NotNull (message = "El campo identificador no debe ser nulo")
	private boolean vigente;
	
	public TareaDTOUpdate() {
		super();
		this.identificador = 0;
		vigente = true;
	}
	
    // Getters y setters
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
    
    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }	
}
