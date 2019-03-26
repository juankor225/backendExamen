package com.backend.examen.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.examen.entidad.Cliente;
import com.backend.examen.entidad.KpiCliente;
import com.backend.examen.entidad.Respuesta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("ControlCliente")
@Api(value = "ControlCliente servicio", description = "Son los métodos controles de los clientes")
public class ControlCliente {

	ArrayList<Cliente> lstClientes = new ArrayList<Cliente>();

	
	public ControlCliente() {
		Cliente cliente = new Cliente();
		
		cliente.setNombre("Juan Antonio");
		cliente.setApellido("Ramirez Uriol");
		cliente.setEdad("31");
		cliente.setFechaNacimiento("16/03/1988");
		lstClientes.add(cliente);
	}

	@RequestMapping(value="/listclientes", method=RequestMethod.GET)
	@ApiOperation(value = "lista todos los clientes", notes = "lista todos los clientes" )
	public ArrayList<Cliente> listarClientes() {
		return lstClientes;
	}
	
	
	@RequestMapping(value="/kpiClientes", method=RequestMethod.GET)
	@ApiOperation(value = "datos kpi de los clientes", notes = "datos kpi de los clientes" )
	public KpiCliente kpiClientes() {
		KpiCliente kpi = new KpiCliente();
		double prm =0.0;
		prm = promedio(prm);
		
		kpi.setPromedioClientes(String.valueOf(prm));
		
		double varianza=0.0;
		
		varianza = varianza(prm, varianza);
		
		if(varianza!=0)
			varianza=varianza/(lstClientes.size()-1);
		
		kpi.setDesviacionEstandar(String.valueOf(Math.sqrt(varianza)));
		
		return kpi;
	}

	private double promedio(double prm) {
		for (Cliente cliente : lstClientes) {
			prm = prm+ Double.parseDouble(cliente.getEdad());
		}
		prm = prm/lstClientes.size();
		return prm;
	}

	private double varianza(double prm, double varianza) {
		for(int i = 0 ; i<lstClientes.size(); i++){
			   double rango;
			   rango = Math.pow(Double.parseDouble(lstClientes.get(i).getEdad()) - prm,2);
			   varianza = varianza + rango;
	    }
		return varianza;
	}
	
	@RequestMapping(value="/creacliente", method=RequestMethod.POST)
	@ApiOperation(value = "agregas clientes", notes = "agregas clientes" )
	public Respuesta agregarCliente(@RequestBody Cliente cliente) {
		lstClientes.add(cliente);
		Respuesta rpta = new Respuesta();
		rpta.setCodigo("0");
		rpta.setMensaje("ok");
		return rpta;
	}
}
