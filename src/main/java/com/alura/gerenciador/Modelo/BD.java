package com.alura.gerenciador.Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BD {
	///prueba 
	private static List<RegistrarEmpresa> lista = new ArrayList<>();
	private static Integer con=1; 
	static {
	RegistrarEmpresa empresa1 = new RegistrarEmpresa();
	RegistrarEmpresa empresa2 = new RegistrarEmpresa();
	empresa1.setNombre("Robinson sa");
	empresa2.setNombre("Casita Linda");
	empresa1.setId(con++);
	empresa2.setId(con++);	
	lista.add(empresa1);
	lista.add(empresa2);
	}
	
	public void agregar(RegistrarEmpresa nuevaEmpresa) {
		nuevaEmpresa.setId(con++);
		BD.lista.add(nuevaEmpresa);
	}
	
	public List<RegistrarEmpresa> mostrar() {
		return BD.lista;
	}
	
	public void eliminarEmpresa(Integer id) {
		Iterator<RegistrarEmpresa> it = lista.iterator();
		while(it.hasNext()) {
			RegistrarEmpresa em = it.next();
			if(em.getId()==id) {
				it.remove();
			}
		}
	}

	public RegistrarEmpresa buscarEmpresa(Integer id) {
		for (RegistrarEmpresa registrarEmpresa : lista) {
			if (registrarEmpresa.getId() ==id) {
				return registrarEmpresa;
			}
		}
		return null;		
	}

	public void guardarModificado(RegistrarEmpresa empresa) {
		  for (RegistrarEmpresa emp : lista) {
	            if (emp.getId().equals(empresa.getId())) {
	                emp.setNombre(empresa.getNombre());
	                emp.setFecha(empresa.getFecha());	                
	                break;
	            }
	        }
		
	}	
}
