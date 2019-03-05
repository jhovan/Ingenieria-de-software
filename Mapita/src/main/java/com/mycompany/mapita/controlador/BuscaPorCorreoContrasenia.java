/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.controlador;

import com.mycompany.mapita.modelo.Usuario;
import com.mycompany.mapita.modelo.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jhovangallardo
 */
@ManagedBean
@SessionScoped
//@RequestScoped
public class BuscaPorCorreoContrasenia {
    private String correo;
    private String contrasenia;
    
    private List<Usuario> resultado;

    public List<Usuario> getResultado() {
        return resultado;
    }
    
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nombre) {
        this.correo = correo;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String nombre) {
        this.contrasenia = contrasenia;
    }
    
    public String buscaPorCorreoContrasenia(){
        if(correo.equals("")||contrasenia.equals(""))
            return "";
        UsuarioDAO ubd = new UsuarioDAO();
        resultado =  ubd.buscaPorCorreoContrasenia(correo,contrasenia);
        return "resultado?faces-redirect=true";
    }
}
