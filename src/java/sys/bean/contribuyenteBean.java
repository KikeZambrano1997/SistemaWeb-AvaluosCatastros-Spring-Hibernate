/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sys.dao.clienteDao;
import sys.dao.contribuyenteDao;
import sys.imp.clienteDaoImp;
import sys.imp.contribuyenteDaoImp;
import sys.model.Cliente;
import sys.model.Contribuyente;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class contribuyenteBean {

    
    private List<Contribuyente> listaContribuyentes;
    private Contribuyente contribuyente;
    
    public contribuyenteBean() {
        contribuyente = new Contribuyente();
    
    }

    public void setListaContribuyentes(List<Contribuyente> listaContribuyentes) {
        this.listaContribuyentes = listaContribuyentes;
    }

   
    public Contribuyente getContribuyente() {
        return contribuyente;
    }
  
    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
    public List<Contribuyente> getListaContribuyentes() {
        contribuyenteDao vDao =new contribuyenteDaoImp();
        listaContribuyentes = vDao.listarContribuyente();
        return listaContribuyentes;
    }
    
    public void prepararNuevoContribuyente(){
          contribuyente= new Contribuyente();
      }
      
      public void nuevoCliente(){
          contribuyenteDao cDao = new contribuyenteDaoImp();
          cDao.newContribuyente(contribuyente);
      }
      public void modificarContribuyente(){
          contribuyenteDao cDao = new contribuyenteDaoImp();
          cDao.updateContribuyente(contribuyente);
          contribuyente = new Contribuyente();
      }
      public void eliminarContribuyente(){
          contribuyenteDao cDao = new contribuyenteDaoImp();
          cDao.deleteContribuyente(contribuyente);
          contribuyente = new Contribuyente();

      }
    
}
