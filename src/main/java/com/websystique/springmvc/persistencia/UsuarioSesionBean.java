/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.persistencia;

import com.websystique.springmvc.dto.UsuarioRolDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DiegoNote
 */
@Stateless
public class UsuarioSesionBean {

    @PersistenceContext(unitName = "com.websystique.springmvc_ProyectoIngSoftware_war_1.0.0PU")
    private EntityManager em;
    
    public UsuarioRolDTO validarUsuario(String run,String pass){
        UsuarioRolDTO usuario=null;
        try{
            usuario=em.createNamedQuery("Usuario.validar",UsuarioRolDTO.class)
                    .setParameter("run", run)
                    .setParameter("pass", pass)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return usuario;
    }
}
