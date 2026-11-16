package com.murimwars.murimwars.controller;

import com.murimwars.murimwars.model.Producto;
import com.murimwars.murimwars.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador MVC: recibe las solicitudes del navegador y coordina el módulo CRUD.
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", service.listar());
        return "productos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Registrar producto");
        return "productos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult resultado,
                          Model model,
                          RedirectAttributes redirect) {
        if (resultado.hasErrors()) {
            model.addAttribute("titulo", producto.getId() == null
                    ? "Registrar producto" : "Editar producto");
            return "productos/formulario";
        }

        try {
            service.guardar(producto);
            redirect.addFlashAttribute("exito", "Producto guardado correctamente.");
            return "redirect:/productos";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("titulo", producto.getId() == null
                    ? "Registrar producto" : "Editar producto");
            model.addAttribute("errorGeneral", ex.getMessage());
            return "productos/formulario";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", service.buscarPorId(id));
        model.addAttribute("titulo", "Editar producto");
        return "productos/formulario";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirect) {
        service.eliminar(id);
        redirect.addFlashAttribute("exito", "Producto eliminado correctamente.");
        return "redirect:/productos";
    }
  @GetMapping("/")
public String inicio() {
    return "redirect:/productos";
}  
}

