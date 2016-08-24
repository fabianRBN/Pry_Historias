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
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
   
    @Autowired
    private HistoriaDAO historiaDAO;
    @Autowired
    private LugarDAO lugarDAO;
    
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
    @RequestMapping(value = "/listarHistoria", method = RequestMethod.GET)
    public String listar(Model m) {
        try {
            List<Historia> resultado = historiaDAO.listar();
            m.addAttribute("resultado", resultado);
            return "Historia/listadoHistoria";
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
    @ModelAttribute("ListaLugares")
    public List<Lugar> cargarListaLugares() throws ServicioExcepcion {
        
        List<Lugar> destinos = lugarDAO.listar();
        return destinos;
    }
     @RequestMapping(value = "/crearHistoria", method = RequestMethod.GET)
    public String crear(ModelMap m) {
        Historia historia = new Historia();
        m.addAttribute("historia", historia);
        return "Historia/crear";
    }
     

    @RequestMapping(value = "/crearHistoria", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("historia") Historia historia,Model m) throws ServicioExcepcion{
        int idLugar = historia.getLugarID();
        Lugar  lugar = this.lugarDAO.consultar(idLugar);
        historia.setIdLugar(lugar);
        historiaDAO.crear(historia);
        return listar(m);
    }
    
    
}
