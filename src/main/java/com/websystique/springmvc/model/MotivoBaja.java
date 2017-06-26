/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoNote
 */
@Entity
@Table(name = "motivo_baja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoBaja.findAll", query = "SELECT m FROM MotivoBaja m"),
    @NamedQuery(name = "MotivoBaja.findByIdMotivoBaja", query = "SELECT m FROM MotivoBaja m WHERE m.idMotivoBaja = :idMotivoBaja"),
    @NamedQuery(name = "MotivoBaja.findByDescripcion", query = "SELECT m FROM MotivoBaja m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MotivoBaja.findByCantidad", query = "SELECT m FROM MotivoBaja m WHERE m.cantidad = :cantidad")})
public class MotivoBaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo_baja")
    private Integer idMotivoBaja;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public MotivoBaja() {
    }

    public MotivoBaja(Integer idMotivoBaja) {
        this.idMotivoBaja = idMotivoBaja;
    }

    public MotivoBaja(Integer idMotivoBaja, String descripcion, int cantidad) {
        this.idMotivoBaja = idMotivoBaja;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Integer getIdMotivoBaja() {
        return idMotivoBaja;
    }

    public void setIdMotivoBaja(Integer idMotivoBaja) {
        this.idMotivoBaja = idMotivoBaja;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivoBaja != null ? idMotivoBaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoBaja)) {
            return false;
        }
        MotivoBaja other = (MotivoBaja) object;
        if ((this.idMotivoBaja == null && other.idMotivoBaja != null) || (this.idMotivoBaja != null && !this.idMotivoBaja.equals(other.idMotivoBaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.websystique.springmvc.model.MotivoBaja[ idMotivoBaja=" + idMotivoBaja + " ]";
    }
    
}
