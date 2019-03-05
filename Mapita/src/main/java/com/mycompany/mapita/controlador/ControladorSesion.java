/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.controlador;

import com.mycompany.mapita.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jhovangallardo
 */
@ManagedBean
@SessionScoped
public class ControladorSesion {
    private String correo;
    private String contrasesnia;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasesnia() {
        return contrasesnia;
    }

    public void setContrasesnia(String contrasesnia) {
        this.contrasesnia = contrasesnia;
    }
    
    /*
    public String login(){
        Usuario user = null;
        FacesContext context = FacesContext.getCurrentInstance();
        if(user !=null){
            context.getExternalContext().getSessionMap().put("user", user);
            return "perfil?faces-redirect=true";
        }
        return "";
    }
    */
    
    public String login(Usuario user){
        //Usuario user = null;
        FacesContext context = FacesContext.getCurrentInstance();
        if(user !=null){
            context.getExternalContext().getSessionMap().put("user", user);
            return "perfil?faces-redirect=true";
        }
        return "";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
