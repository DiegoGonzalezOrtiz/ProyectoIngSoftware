/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author DiegoNote
 */
@Embeddable
public class SolicitudPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @Column(name = "PRODUCTO_id_producto")
    private int pRODUCTOidproducto;

    public SolicitudPK() {
    }

    public SolicitudPK(int idUsuario, int pRODUCTOidproducto) {
        this.idUsuario = idUsuario;
        this.pRODUCTOidproducto = pRODUCTOidproducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPRODUCTOidproducto() {
        return pRODUCTOidproducto;
    }

    public void setPRODUCTOidproducto(int pRODUCTOidproducto) {
        this.pRODUCTOidproducto = pRODUCTOidproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) pRODUCTOidproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudPK)) {
            return false;
        }
        SolicitudPK other = (SolicitudPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.pRODUCTOidproducto != other.pRODUCTOidproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.websystique.springmvc.model.SolicitudPK[ idUsuario=" + idUsuario + ", pRODUCTOidproducto=" + pRODUCTOidproducto + " ]";
    }
    
}
