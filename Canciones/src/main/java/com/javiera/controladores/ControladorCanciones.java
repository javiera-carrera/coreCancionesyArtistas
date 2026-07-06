package com.javiera.controladores;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.javiera.modelos.Cancion;
import com.javiera.servicios.ServicioArtistas;
import com.javiera.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {
    private final ServicioCanciones sCanciones;
    private final ServicioArtistas sArtistas;

    public ControladorCanciones(ServicioCanciones sCanciones, ServicioArtistas sArtistas) {
        this.sCanciones = sCanciones;
        this.sArtistas = sArtistas;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("listaCanciones", sCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model model) {
        model.addAttribute("cancion", sCanciones.obtenerCancionPorId(id));
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
        model.addAttribute("listaArtistas", sArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaArtistas", sArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }
        sCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long id, Model model) {
        model.addAttribute("cancion", sCanciones.obtenerCancionPorId(id));
        model.addAttribute("listaArtistas", sArtistas.obtenerTodosLosArtistas());
        return "editarCancion";
    }

    @PostMapping("/canciones/procesa/editar/{id}")
    public String procesarEditarCancion(@PathVariable("id") Long id, @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaArtistas", sArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }
        sCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long id) {
        sCanciones.eliminaCancion(id);
        return "redirect:/canciones";
    }
}