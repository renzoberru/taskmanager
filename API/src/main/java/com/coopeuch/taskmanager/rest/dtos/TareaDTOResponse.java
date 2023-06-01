package com.coopeuch.taskmanager.rest.dtos;

import java.time.LocalDateTime;

public class TareaDTOResponse extends TareaDTO {
	private Integer identificador;
	private LocalDateTime fechaCreacion;
	private boolean vigente;
	
	public TareaDTOResponse() {
		super();
		this.identificador = 0;
    	this.fechaCreacion = LocalDateTime.now();
    	this.vigente = true;    	
	}
	
	 // Getters y setters
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }		
}
