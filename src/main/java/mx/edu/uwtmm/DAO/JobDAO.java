/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uwtmm.DAO;

import mx.edu.uwtmm.Controller.HibernateUtil;
import mx.edu.uwtmm.VO.Job;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author xr45
 */
public class JobDAO {
    public void addJob(Job obj){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            
            if(obj.getId() != null){
                sesion.save(obj);
            }else{
                sesion.update(obj);
            }
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public void deleteJob(Job obj){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            if(obj.getId() != null){
                sesion.delete(obj);
            }
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public Job findJob(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Job obj = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Job)sesion.load(Job.class, id);
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj;
    }
}
