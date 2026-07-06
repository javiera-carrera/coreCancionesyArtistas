<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle del Artista</title>
</head>
<body>
    <h1>Perfil del Artista</h1>

    <p><strong>Nombre Completo:</strong> ${artista.nombre} ${artista.apellido}</p>
    <p><strong>Biografía:</strong> ${artista.biografia}</p>

    <hr>
    <h3>Canciones de este artista:</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li><a href="/canciones/detalle/${cancion.id}">${cancion.titulo}</a> (${cancion.genero})</li>
        </c:forEach>
        <c:if test="${empty artista.canciones}">
            <li style="color: gray; font-style: italic;">Este artista no tiene canciones registradas aún.</li>
        </c:if>
    </ul>

    <br><br>
    <a href="/artistas">Volver a la lista de artistas</a>
</body>
</html>