<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Catálogo de Canciones</title>
</head>
<body>
    <h1>Lista de Canciones Disponibles</h1>
    
    <table border="1" cellpadding="8" style="border-collapse: collapse;">
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${listaCanciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
                    <td>
                        <a href="/canciones/detalle/${cancion.id}">Ver Detalle</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br><br>
    <a href="/canciones/formulario/agregar"><button>Agregar una Canción</button></a>
    
    <br><br>
    <a href="/artistas">Ir a la lista de artistas</a>
</body>
</html>