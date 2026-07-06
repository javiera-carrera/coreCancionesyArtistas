package com.javiera.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.javiera.modelos.Cancion;

@Repository // Le avisa a Spring que este archivo maneja la Base de Datos
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    
    // Este método le dice a Spring que devuelva todo en formato de Lista de Java
    List<Cancion> findAll();
}