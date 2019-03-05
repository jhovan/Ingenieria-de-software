/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.controlador;

import com.mycompany.mapita.modelo.Marcador;
import com.mycompany.mapita.modelo.MarcadorDAO;
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

public class BuscaPorDescripcion {
    private String descripcion;
    
    private List<Marcador> resultado;

    public List<Marcador> getResultado() {
        return resultado;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public String buscaPorDescripcion(){
        if(descripcion.equals(""))
            return "";
        MarcadorDAO ubd = new MarcadorDAO();
        resultado =  ubd.buscaPorDescripcion(descripcion);
        return "resultado_buscar_marcador?faces-redirect=true";
    }
}
