/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uwtmm.DAO;

import mx.edu.uwtmm.Controller.HibernateUtil;
import mx.edu.uwtmm.VO.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author xr45
 */
public class AccountDAO {
    int id = 0;
    public void addAccount(Account obj){
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
    
    public void deleteAccount(Account obj){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            
            if(obj.getId()!= null){
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
    
    public Account findAccount(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Account obj = null;
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Account)sesion.load(Account.class,id);
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
    
    public Account loginAccount(String email){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Account obj = null;
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Account)sesion.load(Account.class,email);
            transaction.commit();
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();;
            }
            
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj;
    }
}
