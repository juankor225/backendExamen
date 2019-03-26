package com.backend.examen.entidad;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({"nombre", "apellido","edad","fechaNacimiento"})
@ApiModel("Model User")
public class Cliente {
	@NotNull
	@ApiModelProperty(value = "nombre completo", required = true)
	private String nombre;
	@NotNull
	@ApiModelProperty(value = "apellido completo", required = true)
	private String apellido;
	@NotNull
	@ApiModelProperty(value = "edad", required = true)
	private String edad;
	@NotNull
	@ApiModelProperty(value = "fecha nacimiento", required = true)
	private String fechaNacimiento;

	public Cliente(String nombre, String apellido, String edad, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
