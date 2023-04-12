package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.Accion.ListarEmpresa;
import com.alura.gerenciador.Accion.NuevaEmpresa;
import com.alura.gerenciador.Accion.eliminarEmpresa;
import com.alura.gerenciador.Accion.guardarModificado;
import com.alura.gerenciador.Accion.modificarEmpresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ac = request.getParameter("accion");

		if (ac.equals("ListarEmpresa")) {
			ListarEmpresa le = new ListarEmpresa();
			le.ejecutar(request, response);
		} else {
			if (ac.equals("GuardarEmpresa")) {
				System.out.println("Mostrar Empresa");
				guardarModificado gm = new guardarModificado();
				gm.ejecutar(request, response);
			} else {
				if (ac.equals("eliminarEmpresa")) {
					System.out.println("Eliminar empresa");
					eliminarEmpresa ee = new eliminarEmpresa();
					ee.ejecutar(request, response);
				} else {
					if (ac.equals("NuevaEmpresa")) {
						System.out.println("Nueva empresa");
						NuevaEmpresa ne = new NuevaEmpresa();
						ne.ejecutar(request, response);
					} else {
						if (ac.equals("modificarEmpresa")) {
							System.out.println("modificar empresa");
							modificarEmpresa me = new modificarEmpresa();
							me.ejecutar(request, response);
						}
					}
				}
			}
		}
	}
}
