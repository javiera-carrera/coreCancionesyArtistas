<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Artistas</title>
</head>
<body>
    <h1>Artistas Registrados</h1>

    <ul>
        <c:forEach var="artista" items="${listaArtistas}">
            <li>
                <a href="/artistas/detalle/${artista.id}">
                    <strong>${artista.nombre} ${artista.apellido}</strong>
                </a>
            </td>
            </li>
        </c:forEach>
    </ul>

    <br>
    <a href="/artistas/formulario/agregar"><button>Registrar un nuevo artista</button></a>
    
    <br><br>
    <a href="/canciones">Ir al catálogo de canciones</a>
</body>
</html>