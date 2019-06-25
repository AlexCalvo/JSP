/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Callespoblaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
@Stateless
public class CallespoblacionesFacade extends AbstractFacade<Callespoblaciones> {

    @PersistenceContext(unitName = "SegundoParcial19JSP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CallespoblacionesFacade() {
        super(Callespoblaciones.class);
    }
    
}
