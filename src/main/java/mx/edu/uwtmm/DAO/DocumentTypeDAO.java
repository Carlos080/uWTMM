/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.uwtmm.DAO;


import mx.edu.uwtmm.Controller.HibernateUtil;
import mx.edu.uwtmm.VO.DocumentType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author xr45
 */
public class DocumentTypeDAO {
    public void addDocumentType(DocumentType obj){
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
    
    public void deleteDocument(DocumentType obj){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        sesion.delete(obj);
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            sesion.delete(obj);
            if(obj.getId() != null){
                transaction.commit();
            }
                
        }catch(HibernateException he){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public DocumentType findDocumentData(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        DocumentType obj = null;
        
        try{
            sesion = sf.getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (DocumentType)sesion.load(DocumentType.class, id);
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
