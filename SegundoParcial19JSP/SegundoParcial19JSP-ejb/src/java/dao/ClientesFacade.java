/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Clientes;
import entity.Provincias;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hp
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "SegundoParcial19JSP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    public List<Clientes> findByProvincia(Integer id) {
        Query q;
        q = this.em.createQuery("select c from Clientes c where c.codigoprovincia.codigoprovincia = :id");
        q.setParameter("id",id);
        return q.getResultList();
    }
    
}
