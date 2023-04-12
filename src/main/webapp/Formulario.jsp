<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso de Empresa</title>
</head>
<body>

<c:url value="entrada?accion=NuevaEmpresa" var="linkServeletNuevaEmpresa" />

	<form action="${linkServeletNuevaEmpresa}" method="post">
		Nombre De la Empresa: <input type="text" name="Nombre" /> <br>
		Fecha de Creacion: <input type="date" name="fecha" /> <input
			type="submit" />
	</form>

</body>
</html>