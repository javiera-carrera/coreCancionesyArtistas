<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de la Canción</title>
</head>
<body>
    <h1>Ficha Técnica de la Canción</h1>

    <p><strong>Id:</strong> ${cancion.id}</p>
    <p><strong>Título:</strong> ${cancion.titulo}</p>
    <p><strong>Artista:</strong> ${cancion.artista.nombre} ${cancion.artista.apellido}</p>
    <p><strong>Álbum:</strong> ${cancion.album}</p>
    <p><strong>Género:</strong> ${cancion.genero}</p>
    <p><strong>Idioma:</strong> ${cancion.idioma}</p>
    
    <hr>
    
    <a href="/canciones/formulario/editar/${cancion.id}"><button style="background-color: #ffc107;">Editar Canción</button></a>
    
    <br><br>
    
    <form action="/canciones/eliminar/${cancion.id}" method="POST" onsubmit="return confirm('¿Segura que quieres eliminar esta canción?');">
        <input type="hidden" name="_method" value="DELETE">
        <button type="submit" style="background-color: #dc3545; color: white;">Eliminar Canción</button>
    </form>

    <br><br>
    <a href="/canciones">Volver a lista de canciones</a>
</body>
</html>