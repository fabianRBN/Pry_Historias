/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;
import com.modelo.Lugar;
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
public class LugarDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public List<Lugar> listar() throws ServicioExcepcion {
        em.getEntityManagerFactory().getCache().evictAll();
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void crear(Lugar r) throws ServicioExcepcion {
        em.persist(r);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void actualizar(Lugar d) throws ServicioExcepcion {
        em.merge(d);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public void eliminar(int id) throws ServicioExcepcion {
        Lugar des = this.consultar(id);
        em.remove(des);
    }

    @Transactional(rollbackFor = {ServicioExcepcion.class})
    public Lugar consultar(int id) {
        return em.find(Lugar.class, id);
    }
    
      

}
