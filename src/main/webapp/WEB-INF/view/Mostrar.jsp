<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<c:if test="${not empty nombre}">
	 Empresa ${nombre} Registrada!
	</c:if>
	
	<c:if test="${ empty nombre }">
	Ninguna Empresa Registrada!
	</c:if>
	
</body>
</html>