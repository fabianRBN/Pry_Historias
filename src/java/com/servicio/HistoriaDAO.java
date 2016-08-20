/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;
import com.modelo.Historia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Fabian
 */
@Service
public class HistoriaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public List<Historia> listar() throws ServicioExcepcion {
        return em.createNamedQuery("Destino.findAll").getResultList();
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void crear(Historia h) throws ServicioExcepcion {
        em.persist(h);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void actualizar(Historia h) throws ServicioExcepcion {
        em.merge(h);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void eliminar(int id) throws ServicioExcepcion {
        Historia h = this.consultar(id);
        em.remove(h);
    }
    
    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public Historia consultar(int id) {
       return em.find(Historia.class, id);
    }
}
