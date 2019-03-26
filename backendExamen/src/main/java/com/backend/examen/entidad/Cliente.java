package com.backend.examen.entidad;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonPropertyOrder({"nombre", "apellido","edad","fechaNacimiento"})
@ApiModel("Model User")
@JsonSerialize(include = Inclusion.NON_NULL)
public class Cliente {
	private int promedio_edad=86;
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
	@NotNull
	@ApiModelProperty(value = "fecha problable muerte", required = true)
	private String fecha_probable_muerte;


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

	public String getFecha_probable_muerte() {
		Date objDate = new Date();
		Calendar cal = Calendar.getInstance(); 
        cal.setTime(objDate); 
        cal.add(Calendar.YEAR, promedio_edad - Integer.valueOf(edad));
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

		return formateador.format(cal.getTime());
	}

	public void setFecha_probable_muerte(String fecha_probable_muerte) {
		this.fecha_probable_muerte = fecha_probable_muerte;
	}
	
	

}
