<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><title>Agregar Canción</title></head>
<body>
    <h1>Nueva Canción</h1>
    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        <p>
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo"/>
            <form:errors path="titulo" cssStyle="color:red;"/>
        </p>
        <p>
            <form:label path="artista">Artista:</form:label>
            <form:select path="artista">
                <c:forEach var="art" items="${listaArtistas}">
                    <form:option value="${art.id}">${art.nombre} ${art.apellido}</form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album"/>
            <form:errors path="album" cssStyle="color:red;"/>
        </p>
        <p>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero"/>
            <form:errors path="genero" cssStyle="color:red;"/>
        </p>
        <p>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma"/>
            <form:errors path="idioma" cssStyle="color:red;"/>
        </p>
        <button type="submit">Guardar</button>
    </form:form>
    <br>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>