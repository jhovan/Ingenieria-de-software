/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.modelo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jhovangallardo
 */
public class MarcadorDAO extends AbstractDAO<Marcador>{
    /**
     * 
     */
    public MarcadorDAO(){
        super();
    }
    
    
    /**
     * 
     * @param marcador 
     */
    @Override
    public void save(Marcador marcador){
        super.save(marcador);
    }
    
    /**
     * 
     * @param marcador 
     */
    @Override
    public void update(Marcador marcador){
        super.save(marcador);
    }
    
    /**
     * 
     * @param marcador 
     */
    @Override
    public void delete(Marcador marcador){
        super.delete(marcador);
    }
       
    /**
     * 
     * @param id
     * @return 
     */
    public Marcador find(int id){
        return super.find(Marcador.class, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<Marcador> findAll(){
        return super.findAll(Marcador.class);
    }
    
    public List<Marcador> buscaPorDescripcion(String descripcion){
//        if(nombre.equals(""))
//            return null;
        List<Marcador> marcadores =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Marcador  m where m.descripcion like concat('%',:descripcion,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("descripcion", descripcion);
            marcadores = (List<Marcador>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return marcadores;
    }
}
