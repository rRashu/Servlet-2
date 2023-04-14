package com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.alura.gerenciador.Accion.Accion;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ac = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		Boolean esUsusarioNoLogeado = (sesion.getAttribute("loginUsuario")==null);
		Boolean Protegido = !(ac.equals("Login") || ac.equals("FormularioLogin"));

		if (esUsusarioNoLogeado && Protegido) {
			response.sendRedirect("entrada?accion=FormularioLogin");
			return;
		}
		
		
		
		
		
		
		String nombreClase = "com.alura.gerenciador.Accion." + ac;

		String entrada = null;
		
		try {
			Class clase = Class.forName(nombreClase);			
			
			Accion accion = (Accion) clase.newInstance();
			
			entrada = accion.ejecutar(request, response);
		} catch (InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] separado = entrada.split(":");

		if (separado[0].equals("RequestDispatcher")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + separado[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(separado[1]);
		}

		/*
		 * if (ac.equals("ListarEmpresa")) { ListarEmpresa le = new ListarEmpresa();
		 * entrada = le.ejecutar(request, response); } else { if
		 * (ac.equals("GuardarEmpresa")) { System.out.println("Mostrar Empresa");
		 * guardarModificado gm = new guardarModificado(); entrada =
		 * gm.ejecutar(request, response); } else { if (ac.equals("eliminarEmpresa")) {
		 * System.out.println("Eliminar empresa"); eliminarEmpresa ee = new
		 * eliminarEmpresa(); entrada = ee.ejecutar(request, response); } else { if
		 * (ac.equals("NuevaEmpresa")) { System.out.println("Nueva empresa");
		 * NuevaEmpresa ne = new NuevaEmpresa(); entrada = ne.ejecutar(request,
		 * response); } else { if (ac.equals("modificarEmpresa")) {
		 * System.out.println("modificar empresa"); modificarEmpresa me = new
		 * modificarEmpresa(); entrada = me.ejecutar(request, response); } } } } }
		 */

	}
}
