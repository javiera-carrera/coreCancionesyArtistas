package com.javiera.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.javiera.modelos.Cancion;
import com.javiera.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    private final RepositorioCanciones repo;
    public ServicioCanciones(RepositorioCanciones repo) { this.repo = repo; }
    
    public List<Cancion> obtenerTodasLasCanciones() { return repo.findAll(); }
    public Cancion obtenerCancionPorId(Long id) { return repo.findById(id).orElse(null); }
    public Cancion agregarCancion(Cancion c) { return repo.save(c); }
    public Cancion actualizaCancion(Cancion c) { return repo.save(c); }
    public void eliminaCancion(Long id) { repo.deleteById(id); }
}