/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Cliente;
import sys.model.Contribuyente;

/**
 *
 * @author Usuario
 */
public interface contribuyenteDao {
    
    public List<Contribuyente> listarContribuyente();
    public void newContribuyente(Contribuyente contribuyente);
    public void updateContribuyente(Contribuyente contribuyente);
    public void deleteContribuyente(Contribuyente contribuyente);
}
