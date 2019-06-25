/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Orderdetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
@Stateless
public class OrderdetailsFacade extends AbstractFacade<Orderdetails> {

    @PersistenceContext(unitName = "ZecondParcial19-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderdetailsFacade() {
        super(Orderdetails.class);
    }
    
}
