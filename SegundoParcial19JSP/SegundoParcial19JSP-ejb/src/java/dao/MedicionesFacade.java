/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Mediciones;
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
public class MedicionesFacade extends AbstractFacade<Mediciones> {

    @PersistenceContext(unitName = "SegundoParcial19JSP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicionesFacade() {
        super(Mediciones.class);
    }

    public List<Mediciones> findByCliente(Integer id) {
        Query q;
        q = this.em.createQuery("select m from Mediciones m where m.cliente.codigo = :id order by m.fechahora desc");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
}
