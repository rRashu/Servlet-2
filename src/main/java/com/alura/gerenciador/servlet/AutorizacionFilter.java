package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtro de autorizacion ");
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response = (HttpServletResponse) servletresponse;
		
		String ac = request.getParameter("accion");
		
		HttpSession sesion = request.getSession();
		Boolean esUsusarioNoLogeado = (sesion.getAttribute("loginUsuario") == null);
		Boolean Protegido = !(ac.equals("Login") || ac.equals("FormularioLogin"));

		if (esUsusarioNoLogeado && Protegido) {
			response.sendRedirect("entrada?accion=FormularioLogin");
			return;
		}

		chain.doFilter(request, response);
	}

}
