/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp.dao;

import customerapp.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author guzman
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "CustomerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public List<Customer> findByZip (String zipcode) {
        Query q;
        
        q = this.em.createQuery("select c from Customer c where c.zip.zipCode = :id");
        q.setParameter("id", zipcode);
        return q.getResultList();                
    }    
    
    public List<Customer> findByName (String name) {
        Query q;
        
        q = this.em.createQuery("select c from Customer c where c.name like :nombre");
        q.setParameter("nombre", "%" + name + "%");
        return q.getResultList();                
    }    
    
    
    public List<Customer> findByZipAndName (String zipcode, String name) {
        boolean bZip, bName;
        List<Customer> lista;
        
        bZip = (zipcode != null &&  !"".equals(zipcode));
        bName = (name != null &&  !"".equals(name)); 
        
        if (!bZip) {
            if (!bName) {
                lista = this.findAll();        
            } else {
                lista = this.findByName(name);
            }
        } else {
            if (!bName) {
                lista = this.findByZip(zipcode);

            } else {
                Query q;
                q = this.getEntityManager().createQuery("select c from Customer c where c.zip.zipCode = :id and " +
                        "c.name like :nombre");
                q.setParameter("id", zipcode);
                q.setParameter("nombre", "%" + name + "%");                
                lista = q.getResultList();
            }            
        }                
        return lista;        
    }
    
    // -------------------------------------------------------------------------------------
    // ESTE MÉTODO ES MUY INEFICIENTE PERO EN EL DISEÑO DE ESTA BASE DE DATOS NO SE 
    // CONFIGURARON LAS CLAVES PRIMARIAS COMO VALORES AUTOINCREMENTADOS Y POR ESTA RAZÓN
    // TIENE QUE HACERSE ASÍ.
    // -------------------------------------------------------------------------------------    
    protected Integer obtenerSiguienteId () {
        Query q;
        
        q = em.createQuery("select max(c.customerId) from Customer c");
        Integer entero = (Integer)q.getSingleResult();
        if (entero == null) {
            entero = 0;
        }
            
        return entero + 1;        
    }
    
    public void crearNuevo (Customer cliente) {
        Integer id;
        id = this.obtenerSiguienteId();
        cliente.setCustomerId(id);
        this.create(cliente);
    }    
}
