package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GuardarModificadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Nombre = request.getParameter("Nombre");
		String Fecha = request.getParameter("Fecha");
		String Id = request.getParameter("Id");
		RegistrarEmpresa empresa = new RegistrarEmpresa(Id,Nombre,Fecha);
		BD bd =new BD();
		bd.guardarModificado(empresa);
		response.sendRedirect("ListarEmpresa");
	}
}
