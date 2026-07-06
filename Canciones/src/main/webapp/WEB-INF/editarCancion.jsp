<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Canción</title>
</head>
<body>
    <h1>Modificar Datos de la Canción</h1>

    <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
        <form:hidden path="id"/>
        
        <p>
            <form:label path="titulo">Título de la canción:</form:label><br>
            <form:input path="titulo"/>
            <form:errors path="titulo" cssStyle="color: red; font-style: italic;"/>
        </p>
        
        <p>
            <form:label path="artista">Seleccionar Artista:</form:label><br>
            <form:select path="artista">
                <c:forEach var="art" items="${listaArtistas}">
                    <form:option value="${art.id}">${art.nombre} ${art.apellido}</form:option>
                </c:forEach>
            </form:select>
        </p>
        
        <p>
            <form:label path="album">Álbum:</form:label><br>
            <form:input path="album"/>
            <form:errors path="album" cssStyle="color: red; font-style: italic;"/>
        </p>
        
        <p>
            <form:label path="genero">Género Musical:</form:label><br>
            <form:input path="genero"/>
            <form:errors path="genero" cssStyle="color: red; font-style: italic;"/>
        </p>
        
        <p>
            <form:label path="idioma">Idioma:</form:label><br>
            <form:input path="idioma"/>
            <form:errors path="idioma" cssStyle="color: red; font-style: italic;"/>
        </p>
        
        <button type="submit" style="background-color: #28a745; color: white;">Guardar Cambios</button>
    </form:form>

    <br><br>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>