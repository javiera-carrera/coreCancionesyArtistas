package com.javiera.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.javiera.modelos.Artista;
import com.javiera.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    
    private final RepositorioArtistas repoArtistas;

    public ServicioArtistas(RepositorioArtistas repoArtistas) {
        this.repoArtistas = repoArtistas;
    }
    
    
    public List<Artista> obtenerTodosLosArtistas() {
        return repoArtistas.findAll();
    }
    
    
    public Artista obtenerArtistaPorId(Long id) {
        return repoArtistas.findById(id).orElse(null);
    }
    
    
    public Artista agregarArtista(Artista unArtista) {
        return repoArtistas.save(unArtista);
    }
}