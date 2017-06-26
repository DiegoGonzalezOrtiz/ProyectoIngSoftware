/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.configuration;

import org.springframework.web.bind.annotation.RestController;
import com.websystique.springmvc.dto.UsuarioRolDTO;
import com.websystique.springmvc.persistencia.UsuarioSesionBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DiegoNote
 */
@RestController
public class UsuarioRestService {
    @RequestMapping(value = "/Usuario/{run}/{pass}/", method = RequestMethod.GET)
    public ResponseEntity<UsuarioRolDTO> listAllUsers(@PathVariable("run") String run,@PathVariable("run") String pass) {
        UsuarioSesionBean usuarioBean=new UsuarioSesionBean();
        UsuarioRolDTO usuario=usuarioBean.validarUsuario(run, pass);
        return new ResponseEntity<UsuarioRolDTO>(usuario, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Usuario/{run}/", method = RequestMethod.GET)
    public ResponseEntity<String> holi(@PathVariable("run") String run) {
        return new ResponseEntity<String>(run, HttpStatus.OK);
    }
}
