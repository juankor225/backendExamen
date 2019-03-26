package com.backend.examen.entidad;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"promedioClientes", "desviacionEstandar"})
@ApiModel("Model KpiCliente")
public class KpiCliente {

	@NotNull
	@ApiModelProperty(value = "promedio edad clientes", required = true)
	private String promedioClientes;
	
	@NotNull
	@ApiModelProperty(value = "desviacion estandar edades clientes", required = true)
	private String desviacionEstandar;
	
	public String getPromedioClientes() {
		return promedioClientes;
	}
	public void setPromedioClientes(String promedioClientes) {
		this.promedioClientes = promedioClientes;
	}
	public String getDesviacionEstandar() {
		return desviacionEstandar;
	}
	public void setDesviacionEstandar(String desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}
	
	
}
