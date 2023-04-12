package com.alura.gerenciador.Accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class guardarModificado {

	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Nombre = request.getParameter("Nombre");
		String Fecha = request.getParameter("Fecha");
		String Id = request.getParameter("Id");
		RegistrarEmpresa empresa = new RegistrarEmpresa(Id,Nombre,Fecha);
		BD bd =new BD();
		bd.guardarModificado(empresa);
		response.sendRedirect("entrada?accion=ListarEmpresa");
	}
}
