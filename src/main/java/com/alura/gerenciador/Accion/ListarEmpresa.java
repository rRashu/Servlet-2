package com.alura.gerenciador.Accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListarEmpresa implements Accion{

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("prueba");
		List<RegistrarEmpresa> lista = new BD().mostrar();
		request.setAttribute("empresas", lista);
		return "RequestDispatcher:listarEmpresa.jsp";
	}
}
