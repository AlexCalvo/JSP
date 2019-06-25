/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Film;
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
public class FilmFacade extends AbstractFacade<Film> {

    @PersistenceContext(unitName = "parcialPeliculas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmFacade() {
        super(Film.class);
    }

    public Film buscarPorId(Integer id) {
        Query q;
        q = this.em.createQuery("select f from Film f where f.filmId = :id");
        q.setParameter("id", id);
        return (Film)q.getResultList().get(0);
    }

    public List<Film> findByPatron(String patron) {
        Query q;
        q = this.em.createQuery("select f from Film f where f.title like :patron");
        q.setParameter("patron", patron+"%");
        return q.getResultList();
    }

    
    
}
