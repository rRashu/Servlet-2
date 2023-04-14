<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<c:url value="/entrada?accion=Login" var="linkServeletNuevaEmpresa" />



	<form action="${linkServeletNuevaEmpresa}" method="post">
		Login: <input type="text" name="Login" /> <br>
		Pass: <input type="password" name="contrasena" /> <input
			type="submit" />
	</form>
</body>
</html>