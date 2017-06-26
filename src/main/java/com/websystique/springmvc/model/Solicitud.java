/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DiegoNote
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdUsuario", query = "SELECT s FROM Solicitud s WHERE s.solicitudPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Solicitud.findByPRODUCTOidproducto", query = "SELECT s FROM Solicitud s WHERE s.solicitudPK.pRODUCTOidproducto = :pRODUCTOidproducto"),
    @NamedQuery(name = "Solicitud.findByCantidad", query = "SELECT s FROM Solicitud s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "Solicitud.findByFechaEntrega", query = "SELECT s FROM Solicitud s WHERE s.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudPK solicitudPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "PRODUCTO_id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Solicitud() {
    }

    public Solicitud(SolicitudPK solicitudPK) {
        this.solicitudPK = solicitudPK;
    }

    public Solicitud(SolicitudPK solicitudPK, int cantidad, Date fechaSolicitud, String estado) {
        this.solicitudPK = solicitudPK;
        this.cantidad = cantidad;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public Solicitud(int idUsuario, int pRODUCTOidproducto) {
        this.solicitudPK = new SolicitudPK(idUsuario, pRODUCTOidproducto);
    }

    public SolicitudPK getSolicitudPK() {
        return solicitudPK;
    }

    public void setSolicitudPK(SolicitudPK solicitudPK) {
        this.solicitudPK = solicitudPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudPK != null ? solicitudPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solicitudPK == null && other.solicitudPK != null) || (this.solicitudPK != null && !this.solicitudPK.equals(other.solicitudPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.websystique.springmvc.model.Solicitud[ solicitudPK=" + solicitudPK + " ]";
    }
    
}
