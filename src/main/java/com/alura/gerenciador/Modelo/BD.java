package com.alura.gerenciador.Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BD {
	///prueba 
	private static List<RegistrarEmpresa> listaEmpresa = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer con=1; 
	static {
	RegistrarEmpresa empresa1 = new RegistrarEmpresa();
	RegistrarEmpresa empresa2 = new RegistrarEmpresa();
	empresa1.setNombre("Robinson sa");
	empresa2.setNombre("Casita Linda");
	empresa1.setId(con++);
	empresa2.setId(con++);	
	listaEmpresa.add(empresa1);
	listaEmpresa.add(empresa2);
	
	Usuario u1 = new Usuario();
	u1.setLogin("root");
	u1.setContrasena("root");
	Usuario u2 = new Usuario();
	u2.setLogin("robin");
	u2.setContrasena("robin");
	listaUsuario.add(u1);
	listaUsuario.add(u2);
	}
	
	public void agregar(RegistrarEmpresa nuevaEmpresa) {
		nuevaEmpresa.setId(con++);
		BD.listaEmpresa.add(nuevaEmpresa);
	}
	
	public List<RegistrarEmpresa> mostrar() {
		return BD.listaEmpresa;
	}
	
	public void eliminarEmpresa(Integer id) {
		Iterator<RegistrarEmpresa> it = listaEmpresa.iterator();
		while(it.hasNext()) {
			RegistrarEmpresa em = it.next();
			if(em.getId()==id) {
				it.remove();
			}
		}
	}

	public RegistrarEmpresa buscarEmpresa(Integer id) {
		for (RegistrarEmpresa registrarEmpresa : listaEmpresa) {
			if (registrarEmpresa.getId() ==id) {
				return registrarEmpresa;
			}
		}
		return null;		
	}

	public void guardarModificado(RegistrarEmpresa empresa) {
		  for (RegistrarEmpresa emp : listaEmpresa) {
	            if (emp.getId().equals(empresa.getId())) {
	                emp.setNombre(empresa.getNombre());
	                emp.setFecha(empresa.getFecha());	                
	                break;
	            }
	        }
		
	}

	public Usuario existeUsuario(String paramLogin, String paramcontrasena) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.esIgual(paramLogin, paramcontrasena)) {
				return usuario;
			}
		}
		return null;
	}	
}
