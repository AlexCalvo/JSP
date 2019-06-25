/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Orderdetails;
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
public class OrderdetailsFacade extends AbstractFacade<Orderdetails> {

    @PersistenceContext(unitName = "Parcial19JSP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderdetailsFacade() {
        super(Orderdetails.class);
    }

    public List<Orderdetails> findByOrderNumber(Integer ordernumber) {
        Query q;
        q = this.em.createQuery("select od from Orderdetails od where od.orderdetailsPK.ordernumber = :ordernumber");
        q.setParameter("ordernumber",ordernumber);
        return q.getResultList();
    }
    
}
