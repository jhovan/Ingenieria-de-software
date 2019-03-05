/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.controlador;

import com.mycompany.mapita.modelo.Usuario;
import com.mycompany.mapita.modelo.UsuarioDAO;
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
    private String contrasenia;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    public String login(){
        Usuario user = null;
        BuscaPorCorreoContrasenia busqueda = new BuscaPorCorreoContrasenia();
        busqueda.setContrasenia(contrasenia);
        busqueda.setCorreo(correo);
        busqueda.buscaPorCorreoContrasenia();
        user = busqueda.getResultado();
        FacesContext context = FacesContext.getCurrentInstance();
        if(user !=null){
            context.getExternalContext().getSessionMap().put("user", user);
            return "login?faces-redirect=true";
        }
        return "login?faces-redirect=true";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}
