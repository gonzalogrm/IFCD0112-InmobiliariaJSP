<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Mostrar detalle</title>
	</head>
	<body>
		<h1>Detalles del inmueble</h1>
	
		<table>
				<tr>
					<th>Imagen</th>
					<th>Datos</th>
				</tr>
				<tr>
					<td><img src="<c:url value='img/${inmuebleDetalle.urlimagen}'></c:url>"/>
					<td>	
						Referencia:<c:out value="${inmuebleDetalle.referencia}"/><br/>
						Descripción:<c:out value="${inmuebleDetalle.descripcion}"/><br/>
						Fecha Baja:<c:out value="${inmuebleDetalle.fbaja}"/><br/>		
						Disponible:<c:out value="${inmuebleDetalle.disponible}"/><br/>
						Localidad:<c:out value="${inmuebleDetalle.localidad}"/><br/>
						Dirección:<c:out value="${inmuebleDetalle.direccion}"/><br/>	
						CP:<c:out value="${inmuebleDetalle.cp}"/><br/>					
						Tipo:<c:out value="${inmuebleDetalle.tipo}"/><br/>	
						Superficie:<c:out value="${inmuebleDetalle.metros}"/><br/>	
						Dormitorios:<c:out value="${inmuebleDetalle.dormitorios}"/><br/>
						Banos:<c:out value="${inmuebleDetalle.banos}"/><br/>
						Precio:<c:out value="${inmuebleDetalle.precio}"/><br/>						
					</td>
				</tr>
		</table>	
	</body>
</html>