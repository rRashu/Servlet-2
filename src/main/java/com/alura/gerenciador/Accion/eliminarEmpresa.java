package com.alura.gerenciador.Accion;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class eliminarEmpresa {

	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		BD bd = new BD();
		bd.eliminarEmpresa(id);
		response.sendRedirect("entrada?accion=ListarEmpresa");
	}
}
