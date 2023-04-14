<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso de Empresa</title>
</head>
<body>
<c:import url="LogoutParcial.jsp"></c:import>
<c:url value="entrada?accion=GuardarModificado" var="linkServeletNuevaEmpresa" />

	<form action="${linkServeletNuevaEmpresa}" method="post">
	 	    <input type="hidden" name="Id" value="${empresa.id}" />
		Nombre De la Empresa: <input type="text" name="Nombre" value="${empresa.nombre}" /> <br>
		Fecha de Creacion: <input type="date" name="Fecha"  value="${fecha }"/> <input
			type="submit" />
	</form>
</body>
</html>