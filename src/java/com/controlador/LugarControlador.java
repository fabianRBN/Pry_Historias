/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Lugar;
import com.servicio.LugarDAO;
import com.servicio.ServicioExcepcion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Fabian
 */
@Controller
@RequestMapping("/lugar")
public class LugarControlador {
    @Autowired
    private LugarDAO lugarDAO;
    
     @RequestMapping(method = RequestMethod.GET)
    public String listar(Model m) {
        try {
            List<Lugar> resultado = lugarDAO.listar();
            m.addAttribute("resultado", resultado);
            return "Lugar/listado";
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }

   
    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(ModelMap m){
        Lugar lugar = new Lugar();
        m.addAttribute("lugar",lugar);
        return "Lugar/crear";
    }
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("lugar") Lugar lugar, Model m) throws ServicioExcepcion {
        lugarDAO.crear(lugar);
        return listar(m);
    }
}
