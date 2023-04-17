package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.Accion.Accion;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Filtro de Controlador ");
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;

		String ac = request.getParameter("accion");

		String nombreClase = "com.alura.gerenciador.Accion." + ac;

		String entrada = null;

		try {
			@SuppressWarnings("rawtypes")
			Class clase = Class.forName(nombreClase);

			@SuppressWarnings("deprecation")
			Accion accion = (Accion) clase.newInstance();

			entrada = accion.ejecutar(request, response);
		} catch (InstantiationException | IllegalAccessException e) {

			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String[] separado = entrada.split(":");

		if (separado[0].equals("RequestDispatcher")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + separado[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(separado[1]);
		}
	}

}
