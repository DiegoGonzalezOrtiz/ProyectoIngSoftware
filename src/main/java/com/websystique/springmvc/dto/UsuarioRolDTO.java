/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dto;

import com.websystique.springmvc.model.Rol;
import com.websystique.springmvc.model.Usuario;

/**
 *
 * @author DiegoNote
 */
public class UsuarioRolDTO {
    private Usuario usuario;
    private Rol rol;

    public UsuarioRolDTO() {
    }

    public UsuarioRolDTO(Usuario usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioRolDTO{" + "usuario=" + usuario + ", rol=" + rol + '}';
    }
    
}
