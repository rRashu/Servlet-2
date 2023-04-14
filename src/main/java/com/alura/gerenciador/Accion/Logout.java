package com.alura.gerenciador.Accion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		//elimina el atributo que coloquemos 
//   	sesion.removeAttribute("loginUsuario");
		//todo alv
		sesion.invalidate();
		return "sendRedirect:entrada?accion=FormularioLogin";
	}

}
