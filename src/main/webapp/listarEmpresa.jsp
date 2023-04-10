<%@ page import="com.alura.gerenciador.servlet.RegistrarEmpresa"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
<style>
.tabla-redondeada {
	border-collapse: separate;
	border-spacing: 0;
	border-radius: 10px;
	overflow: hidden;
}

}
.tabla-redondeada th, .tabla-redondeada td {
	border: 1px solid black;
	padding: 10px;
}

.tabla-redondeada th:first-child {
	border-top-left-radius: 10px;
}

.tabla-redondeada th:last-child {
	border-top-right-radius: 10px;
}

.tabla-redondeada tr:last-child td:first-child {
	border-bottom-left-radius: 10px;
}

.tabla-redondeada tr:last-child td:last-child {
	border-bottom-right-radius: 10px;
}

th, td {
	border: 2px solid #333;
	padding: 8px;
}

h1 {
	font-size: 48px;
	color: #333;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 2px;
	margin-top: 50px;
	margin-bottom: 50px;
	color: rgb(00008b);
}
</style>

<meta charset="ISO-8859-1">
<title>Listado de Las Empresa</title>
</head>
<body>


	<c:if test="${not empty nombre}">
	 Empresa ${nombre} Registrada!
	</c:if>


	<h1>Listado de las empresas</h1>



	<table class="tabla-redondeada"
		style="margin-left: auto; margin-right: auto;">
		<tr>
			<th>Id</th>
			<th>Nombre De la Empresa</th>
			<th>Fecha de Creacion</th>
		</tr>

		<c:forEach items="${empresas}" var="empresa">
			<tr>
				<td>${ empresa.id}</td>
				<td>${ empresa.nombre}</td>
				<td><fmt:formatDate value="${empresa.fecha}"
						pattern="dd/MM/YYYY" /></td>

				<td style="border: none;"><a
					href="/gerenciador/modificarEmpresa?id=${empresa.id}"><button>Modificar</button></a></td>

				<td style="border: none;"><a
					href="/gerenciador/eliminarEmpresa?id=${empresa.id}"><button>Eliminar</button></a></td>


			</tr>
		</c:forEach>
	</table>

</body>
</html>