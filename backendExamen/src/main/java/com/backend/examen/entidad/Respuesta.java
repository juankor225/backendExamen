package com.backend.examen.entidad;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"codigo", "mensaje"})
@ApiModel("Model Respuesta")
public class Respuesta {

	@NotNull
	@ApiModelProperty(value = "codigo respuesta", required = true)
	private String codigo;
	
	@NotNull
	@ApiModelProperty(value = "mensaje respuesta", required = true)
	private String mensaje;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
