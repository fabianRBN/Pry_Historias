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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(method = RequestMethod.GET)
    public String listar (Model m){
        try {
            List<Historia> resultado = historiaDAO.listar();
            m.addAttribute("resultado", resultado);
            return "Historia/listado";
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
     @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String crear(ModelMap m) {
        Historia historia= new Historia();
        m.addAttribute("historia", historia);
        return "Historia/crear";
    }
    @ModelAttribute("ListaLugares")
    public List<Lugar> cargarListaOficina() throws ServicioExcepcion {
        List<Lugar> oficinas = lugarDAO.listar();
        return oficinas;
    }
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("historia") Historia historia,Model m) throws ServicioExcepcion {
        
        int id_lugar = historia.getLugarID();
        Lugar lugar = this.lugarDAO.consultar(id_lugar);
        historia.setIdLugar(lugar);
        historiaDAO.crear(historia);
        return listar(m);
    }
    
    
    
}
