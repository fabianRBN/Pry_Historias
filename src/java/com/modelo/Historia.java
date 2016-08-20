/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fabian
 */
@Entity
@Table(name = "historia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h"),
    @NamedQuery(name = "Historia.findByIdHistoria", query = "SELECT h FROM Historia h WHERE h.idHistoria = :idHistoria"),
    @NamedQuery(name = "Historia.findByNombreHistoria", query = "SELECT h FROM Historia h WHERE h.nombreHistoria = :nombreHistoria"),
    @NamedQuery(name = "Historia.findByFechaHistoria", query = "SELECT h FROM Historia h WHERE h.fechaHistoria = :fechaHistoria")})
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia")
    private Integer idHistoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_historia")
    private String nombreHistoria;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_historia")
    private String descripcionHistoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_historia")
    @Temporal(TemporalType.DATE)
    private Date fechaHistoria;
    @JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar")
    @ManyToOne(optional = false)
    private Lugar idLugar;
    @Transient
    private int lugarID;

    public int getLugarID() {
        return lugarID;
    }

    public void setLugarID(int lugarID) {
        this.lugarID = lugarID;
    }
    public Historia() {
    }

    public Historia(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Historia(Integer idHistoria, String nombreHistoria, String descripcionHistoria, Date fechaHistoria) {
        this.idHistoria = idHistoria;
        this.nombreHistoria = nombreHistoria;
        this.descripcionHistoria = descripcionHistoria;
        this.fechaHistoria = fechaHistoria;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getNombreHistoria() {
        return nombreHistoria;
    }

    public void setNombreHistoria(String nombreHistoria) {
        this.nombreHistoria = nombreHistoria;
    }

    public String getDescripcionHistoria() {
        return descripcionHistoria;
    }

    public void setDescripcionHistoria(String descripcionHistoria) {
        this.descripcionHistoria = descripcionHistoria;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    public Lugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Lugar idLugar) {
        this.idLugar = idLugar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoria != null ? idHistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idHistoria == null && other.idHistoria != null) || (this.idHistoria != null && !this.idHistoria.equals(other.idHistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.modelo.Historia[ idHistoria=" + idHistoria + " ]";
    }
    
}
