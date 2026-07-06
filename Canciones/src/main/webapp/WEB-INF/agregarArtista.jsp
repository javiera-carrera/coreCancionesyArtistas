<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Artista</title>
</head>
<body>
    <h1>Registrar Nuevo Artista / Banda</h1>

    <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
        <p>
            <form:label path="nombre">Nombre:</form:label><br>
            <form:input path="nombre" required="required"/>
            <form:errors path="nombre" cssStyle="color: red;"/>
        </p>
        
        <p>
            <form:label path="apellido">Apellido:</form:label><br>
            <form:input path="apellido" required="required"/>
            <form:errors path="apellido" cssStyle="color: red;"/>
        </p>
        
        <p>
            <form:label path="biografia">Biografía:</form:label><br>
            <form:textarea path="biografia" rows="5" cols="30"/>
            <form:errors path="biografia" cssStyle="color: red;"/>
        </p>
        
        <button type="submit" style="background-color: #007bff; color: white;">Guardar Artista</button>
    </form:form>

    <br><br>
    <a href="/artistas">Volver a la lista de artistas</a>
</body>
</html>