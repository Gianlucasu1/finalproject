/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.controlador;

import gestionproyectos.controlador.exceptions.NonexistentEntityException;
import gestionproyectos.modelo.TareaDescripcion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gianlucasorem
 */
public class TareaDescripcionJpaController implements Serializable {

    public TareaDescripcionJpaController( ) {
        this.emf = Persistence.createEntityManagerFactory("GestionProyectosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TareaDescripcion tareaDescripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tareaDescripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TareaDescripcion tareaDescripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tareaDescripcion = em.merge(tareaDescripcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tareaDescripcion.getId();
                if (findTareaDescripcion(id) == null) {
                    throw new NonexistentEntityException("The tareaDescripcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TareaDescripcion tareaDescripcion;
            try {
                tareaDescripcion = em.getReference(TareaDescripcion.class, id);
                tareaDescripcion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tareaDescripcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(tareaDescripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TareaDescripcion> findTareaDescripcionEntities() {
        return findTareaDescripcionEntities(true, -1, -1);
    }

    public List<TareaDescripcion> findTareaDescripcionEntities(int maxResults, int firstResult) {
        return findTareaDescripcionEntities(false, maxResults, firstResult);
    }

    private List<TareaDescripcion> findTareaDescripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TareaDescripcion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TareaDescripcion findTareaDescripcion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TareaDescripcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareaDescripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TareaDescripcion> rt = cq.from(TareaDescripcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
