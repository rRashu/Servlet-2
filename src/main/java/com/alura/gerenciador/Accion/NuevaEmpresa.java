package com.alura.gerenciador.Accion;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NuevaEmpresa {

	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrarEmpresa empresa = new RegistrarEmpresa();
		BD db = new BD();
		// con el getParameter se obtiene lo que pongamos en la pag despues del signo de
		// " ? "
		String NuevaEmpresa = request.getParameter("Nombre");
		String FechaEmpresa = request.getParameter("fecha");
		String[] fechaseparada = FechaEmpresa.split("-");
		String unir = fechaseparada[2] + "/" + fechaseparada[1] + "/" + fechaseparada[0];
		Date fecha = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			fecha = sdf.parse(unir);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		empresa.setNombre(NuevaEmpresa);
		empresa.setFecha(fecha);
		db.agregar(empresa);

//		esto nos permite hacer solo un envio de datos para que no se dupliquen al
//		momento de quiera actualizar la sig pag
//		redirecciona a la sig ventana sin datos (o al menos eso entendi)
		
		response.sendRedirect("entrada?accion=ListarEmpresa");

//		RequestDispatcher rd = request.getRequestDispatcher("/ListarEmpresa");
//		request.setAttribute("nombre", empresa.getNombre());
//		rd.forward(request, response);
	}
}
