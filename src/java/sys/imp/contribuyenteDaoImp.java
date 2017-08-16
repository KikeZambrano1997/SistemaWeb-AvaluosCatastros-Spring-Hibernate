/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.contribuyenteDao;
import sys.model.Cliente;
import sys.model.Contribuyente;
import sys.util.HibernateUtil;

/**
 *
 * @author Usuario
 */
public class contribuyenteDaoImp implements contribuyenteDao {

    @Override
    public List<Contribuyente> listarContribuyente() {
        List<Contribuyente> lista=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql="FROM Contribuyente";
        
        try{
            lista=session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e){
            t.rollback();
        }
        return lista;
    }

    @Override
    public void newContribuyente(Contribuyente contribuyente) {
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(contribuyente);
            session.getTransaction().commit();
       } catch (Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void updateContribuyente(Contribuyente contribuyente) {
 Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(contribuyente);
            session.getTransaction().commit();
       } catch (Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session!=null){
                session.close();
            }
        }    }

    @Override
    public void deleteContribuyente(Contribuyente contribuyente) {
         Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(contribuyente);
            session.getTransaction().commit();
       } catch (Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if (session!=null){
                session.close();
            }
        }
    }
    
}
