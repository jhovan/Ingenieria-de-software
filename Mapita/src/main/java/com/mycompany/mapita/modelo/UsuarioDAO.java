/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.modelo;
import java.util.List;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jhovangallardo
 */
public class UsuarioDAO extends AbstractDAO<Usuario> {
    
    /**
     * 
     */
    public UsuarioDAO(){
        super();
    }
    
    /**
     * 
     * @param usuario 
     */
    @Override
    public void save(Usuario usuario){
        super.save(usuario);
    }
    
    /**
     * 
     * @param usuario 
     */
    @Override
    public  void update(Usuario usuario){
        super.update(usuario);
    }
    
    /**
     * 
     * @param usuario 
     */
    @Override
    public void delete(Usuario usuario){
        super.delete(usuario);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Usuario find(int id){
        return super.find(Usuario.class, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<Usuario> findAll(){
        return super.findAll(Usuario.class);
    
    }
    
    public List<Usuario> buscaPorNombre(String nombre){
//        if(nombre.equals(""))
//            return null;
        List<Usuario> usuarios =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Usuario  u where u.nombre like concat('%',:nombre,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            usuarios = (List<Usuario>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return usuarios;
    }
  
    public Usuario buscaPorCorreoContrasenia(String correo, String contrasenia){
//        if(nombre.equals(""))
//            return null;
        Usuario usuario =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Usuario  u where u.correo = :correo and u.contrasenia = :contrasenia";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia", contrasenia);
            usuario = (Usuario)query.list().get(0);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return usuario;
    }    
}
