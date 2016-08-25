/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.Historia;
import com.modelo.Lugar;
import com.servicio.LugarDAO;
import com.servicio.ServicioExcepcion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String crear(ModelMap m, HttpSession session){
        Historia historia = new Historia();
        Lugar lugar = new Lugar();
        session.setAttribute("lugar", lugar);
        m.addAttribute("lugar",lugar);
        m.addAttribute("historia",historia);
        return "Lugar/crear";
    }
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("lugar") Lugar lugar, Model m,HttpSession session) throws ServicioExcepcion {
        //Recuperamos el lugar
        Lugar lugarSession = (Lugar)session.getAttribute("lugar");
        lugarDAO.crear(lugar,lugarSession.getHistoriaCollection());
        return listar(m);
        
    }
    @RequestMapping(value = "/editar/{idLugar}", method = RequestMethod.GET)
    public String editarVista(@PathVariable("idLugar") String id, Model m) {
        int idLugar = Integer.parseInt(id);
        Lugar resultado = this.lugarDAO.consultar(idLugar);
        m.addAttribute("resultado", resultado);
        Lugar lugar = new Lugar();
        m.addAttribute("lugar",lugar);
        return "Lugar/editar";
    }
    
    @RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String editar(@ModelAttribute("lugar")Lugar lugar, Model m) throws ParseException {
        try {
            this.lugarDAO.actualizar(lugar);
            m.addAttribute("tipoMensaje", true);
            m.addAttribute("mensaje", "Registro de empleado actualizado con éxito");
            return listar(m);
        } catch (ServicioExcepcion ex) {
            m.addAttribute("tipoMensaje", false);
            m.addAttribute("mensaje", ex.getMessage());
            return "error";
        }
    }
     @RequestMapping(value = "/eliminar/{idLugar}", method = RequestMethod.GET)
    public String eliminarVista(@PathVariable("idLugar") String id, Model m) {
        int idLugar = Integer.parseInt(id);
        Lugar resultado = this.lugarDAO.consultar(idLugar);
        m.addAttribute("resultado", resultado);
        return "Lugar/eliminar";
    }

    @RequestMapping(value = "/eliminar/{idLugar}", method = RequestMethod.POST)
    public String eliminar(@PathVariable("idLugar") String id, Model m) {
        try {
            int idLugar = Integer.parseInt(id);
            this.lugarDAO.eliminar(idLugar);
            return "Lugar/exito";
        } catch (ServicioExcepcion ex) {
            m.addAttribute("err", ex.getMessage());
            return "error";
        }
    }
    
    
    

}
