/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Historia;
import com.modelo.Lugar;
import com.servicio.HistoriaDAO;
import com.servicio.LugarDAO;
import com.servicio.ServicioExcepcion;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fabian
 */
@Controller
@RequestMapping("/historia")
public class HistoriaControlador {
    
       @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public ModelAndView verHistorias(ModelAndView m, HttpSession session) throws ServicioExcepcion {
        Lugar lugar = (Lugar) session.getAttribute("lugar");
        m.setViewName("Historia/listado");
        m.addObject("historias", lugar.getHistoriaCollection());
        return m;
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public ModelAndView crearHistoria(@ModelAttribute Historia historia, ModelAndView m, HttpSession session) throws ServicioExcepcion {
        try {
            Lugar lugar = (Lugar) session.getAttribute("lugar");
            lugar.addHistoria(historia);
        } catch (Exception ex) {
            m.addObject("exception", ex.getMessage());
        }
        return verHistorias(m, session);
    }
}
