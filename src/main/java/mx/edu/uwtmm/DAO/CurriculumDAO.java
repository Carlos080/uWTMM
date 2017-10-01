/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uwtmm.DAO;

import mx.edu.uwtmm.Controller.HibernateUtil;
import mx.edu.uwtmm.VO.Curriculum;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author xr45
 */
public class CurriculumDAO {
    public void addCurriculum(Curriculum obj){
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
    
    public void delCurriculum(Curriculum obj){
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
    
    public Curriculum findCurriculum(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Curriculum obj = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Curriculum)sesion.load(Curriculum.class, id);
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
