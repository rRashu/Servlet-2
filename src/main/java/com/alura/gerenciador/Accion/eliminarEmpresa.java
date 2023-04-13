package com.alura.gerenciador.Accion;

import java.io.IOException;

import com.alura.gerenciador.Modelo.BD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class eliminarEmpresa implements Accion{

	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		BD bd = new BD();
		bd.eliminarEmpresa(id);
		return "sendRedirect:entrada?accion=ListarEmpresa";
	}
}
