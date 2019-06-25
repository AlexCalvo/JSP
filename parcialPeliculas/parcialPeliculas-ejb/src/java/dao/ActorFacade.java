/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Actor;
import entity.Category;
import java.util.Arrays;
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
public class ActorFacade extends AbstractFacade<Actor> {

    @PersistenceContext(unitName = "parcialPeliculas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActorFacade() {
        super(Actor.class);
    }
    
    public List<Actor> findFilmByCategorias(String[] c){
        Query q;
        q = this.em.createQuery("select a from Actor a join a.filmList f join f.categoryList c where c.categoryId in :lista");
        q.setParameter("lista", Arrays.asList(c));
        return q.getResultList();
    }
}
