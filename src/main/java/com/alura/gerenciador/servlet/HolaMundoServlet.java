package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//sirve para ocultar el formato de la pag

@WebServlet(urlPatterns ="/hola")
public class HolaMundoServlet extends HttpServlet{
	
	//HttpServletRequest es la peticion de la pag
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hola, creaste tu primer servlet");
		out.println("</body>");
		out.println("</html>");
	}

}
