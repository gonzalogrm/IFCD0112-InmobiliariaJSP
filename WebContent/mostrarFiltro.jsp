<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Filtro</title>
	</head>
	<body>
		<h2>Búsqueda Filtrada</h2>		
		<c:if test="${inmueblesFiltro!=null}">
			<table>
				<tr>
					<th>Imagen</th>
					<th>Datos</th>
					<th>Detalles</th>
				</tr>

				<c:forEach var="e" items="${inmueblesFiltro}">
					<tr>
						<td><img src="<c:url value='img/${e.urlimagen}'></c:url>" /> </td>
						<td>	
							Referencia:<c:out value="${e.referencia}"/><br/>
							Localidad:<c:out value="${e.localidad}"/><br/>
							Dirección:<c:out value="${e.direccion}"/><br/>				
							Tipo:<c:out value="${e.tipo}"/><br/>	
							Superficie:<c:out value="${e.metros}"/><br/>	
							Dormitorios:<c:out value="${e.dormitorios}"/><br/>
							Banos:<c:out value="${e.banos}"/><br/>
							Precio:<c:out value="${e.precio}"/><br/>					
						</td>
						<td><a href="ServletDetalleInmueble?referencia=${e.referencia}">Ver detalle </a></td>
					</tr>			
				</c:forEach>
			</table>			
		</c:if>
	</body>
</html>