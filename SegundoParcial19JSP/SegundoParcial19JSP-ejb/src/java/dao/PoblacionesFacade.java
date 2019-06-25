/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Poblaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hp
 */
@Stateless
public class PoblacionesFacade extends AbstractFacade<Poblaciones> {

    @PersistenceContext(unitName = "SegundoParcial19JSP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoblacionesFacade() {
        super(Poblaciones.class);
    }
    
}
