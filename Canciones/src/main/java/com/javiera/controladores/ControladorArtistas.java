package com.javiera.controladores;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.javiera.modelos.Artista;
import com.javiera.servicios.ServicioArtistas;

@Controller
public class ControladorArtistas {

    private final ServicioArtistas sArtistas;

    // se inyecta el servicio de artistas
    public ControladorArtistas(ServicioArtistas sArtistas) {
        this.sArtistas = sArtistas;
    }

    // se desplegan los artistas en la ruta artistas
    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        model.addAttribute("listaArtistas", sArtistas.obtenerTodosLosArtistas());
        return "artistas"; // Busca /WEB-INF/artistas.jsp
    }

    // se despliega el detalle de un artista
    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long id, Model model) {
        model.addAttribute("artista", sArtistas.obtenerArtistaPorId(id));
        return "detalleArtista"; // Busca /WEB-INF/detalleArtista.jsp
    }

    //formulario para agregar artista
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista"; // Busca /WEB-INF/agregarArtista.jsp
    }

    // procesa formulario de creacion
    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista"; // Si hay errores, regresa al formulario para mostrarlos
        }
        sArtistas.agregarArtista(artista);
        return "redirect:/artistas"; // Si todo está bien, redirige a la lista
    }
}