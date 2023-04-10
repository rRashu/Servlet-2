package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//ejemplo
public class ListarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<RegistrarEmpresa> lista = new BD().mostrar();

		RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresa.jsp");
		request.setAttribute("empresas", lista);
		rd.forward(request, response);
		
		
//investigar sobre expression languages  para jsp
		
		
	}

}
