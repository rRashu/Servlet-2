package com.alura.gerenciador.Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;

public class RegistrarEmpresa {
	private Integer id;
	private String Nombre;
	private Date fecha= new Date();
	

	public RegistrarEmpresa(String id, String nombre, String fecha) throws ServletException {
		
		String[] fechaseparada = fecha.split("-");
		String unir = fechaseparada[2] + "/" + fechaseparada[1] + "/" + fechaseparada[0];
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			this.fecha = sdf.parse(unir);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		this.id =Integer.valueOf(id);
		Nombre = nombre;
		
	}
	
	public RegistrarEmpresa() {
		
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
