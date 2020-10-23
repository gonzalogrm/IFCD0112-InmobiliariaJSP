<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inmobiliaria</title>
	</head>
	<body>
		<h1>Inmobiliaria</h1>
	
		<h2>Buscar</h2>
		<c:if test="${not empty param.precioDesde}">
			<jsp:useBean id="filtroBean" class="com.vipper.modelo.Filtro" scope="request"></jsp:useBean>
			<jsp:setProperty property="*" name="filtroBean"/>			
			<jsp:forward page="ServletDetalleInmueble"></jsp:forward>
		</c:if>
		
		<form action="index.jsp" method="post">
			Precio Desde: <input type="text" name="precioDesde"/><br/>			
			Precio Hasta: <input type="text" name="precioHasta"/><br/>
			Dormitorios: <input type="number" name="dormitorios"/><br/>
			Baños: <input type="number" name="banos"/><br/>			
			<input type="submit" value="Enviar Información"/>
		</form>
		
	
		<h2>Todos los inmuebles</h2>		
		<c:if test="${inmueblesList!=null}">
			<table>
				<tr>
					<th>Imagen</th>
					<th>Datos</th>
					<th>Detalles</th>
				</tr>
				<%//Opción Gabriela: <img src="imagenes/${elemento.urlimagen}"/> %>
				<c:forEach var="e" items="${inmueblesList}">
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