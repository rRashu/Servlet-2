package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import com.alura.gerenciador.Modelo.BD;
import com.alura.gerenciador.Modelo.RegistrarEmpresa;
import com.thoughtworks.xstream.XStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<RegistrarEmpresa> empresas = new BD().mostrar();
	
	
	
	// para crear los xml o json 
	// json = Gson libreria faltante
	// XMl = XStrem,xmlpull  libreria faltante 
	XStream xstream = new XStream();
	
	//cambia la direccion completa de la clase a el alias que  le asignemos 
	xstream.alias("empresa",RegistrarEmpresa.class);
	String xml = xstream.toXML(empresas);
	
	response.setContentType("Application/xml");
	response.getWriter().print(xml);
	
	
	
//	Gson gson = new Gson();
//	String json = gson.toJson(empresas);
//	
//	response.setContentType("Application/json");
//	response.getWriter().print(json);
	}

}
