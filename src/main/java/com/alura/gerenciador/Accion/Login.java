package com.alura.gerenciador.Accion;

import java.io.IOException;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramLogin = request.getParameter("Login");
		String paramcontrasena = request.getParameter("contrasena");
		System.out.println("Login " + paramLogin);
		BD bd = new BD();
		Usuario usuario = bd.existeUsuario(paramLogin, paramcontrasena);
		if (usuario != null) {
			HttpSession seccion = request.getSession();
			seccion.setAttribute("loginUsuario",usuario);
			return "sendRedirect:entrada?accion=ListarEmpresa";
		}else {
			return "sendRedirect:entrada?accion=FormularioLogin";
		}
		
	}

}
