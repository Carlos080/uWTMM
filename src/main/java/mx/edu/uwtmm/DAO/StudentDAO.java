/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uwtmm.DAO;

import mx.edu.uwtmm.Controller.HibernateUtil;
import mx.edu.uwtmm.VO.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author xr45
 */
public class StudentDAO {
    public void addStudent(Student obj){
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
    
    public void deleteStudent(Student obj){
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
    
    public Student findStudent(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Student obj = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Student)sesion.load(Student.class,id);
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
