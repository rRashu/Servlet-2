package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.Modelo.BD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class eliminarEmpresaservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		BD bd = new BD();
		bd.eliminarEmpresa(id);
		response.sendRedirect("ListarEmpresa");
	}

}
