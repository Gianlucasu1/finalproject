/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.controlador;

import gestionproyectos.controlador.exceptions.NonexistentEntityException;
import gestionproyectos.modelo.TareasProyecto;
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
public class TareasProyectoJpaController1 implements Serializable {

    public TareasProyectoJpaController1( ) {
        this.emf = Persistence.createEntityManagerFactory("GestionProyectosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TareasProyecto tareasProyecto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tareasProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TareasProyecto tareasProyecto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tareasProyecto = em.merge(tareasProyecto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tareasProyecto.getIdTareasProyecto();
                if (findTareasProyecto(id) == null) {
                    throw new NonexistentEntityException("The tareasProyecto with id " + id + " no longer exists.");
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
            TareasProyecto tareasProyecto;
            try {
                tareasProyecto = em.getReference(TareasProyecto.class, id);
                tareasProyecto.getIdTareasProyecto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tareasProyecto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tareasProyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TareasProyecto> findTareasProyectoEntities() {
        return findTareasProyectoEntities(true, -1, -1);
    }

    public List<TareasProyecto> findTareasProyectoEntities(int maxResults, int firstResult) {
        return findTareasProyectoEntities(false, maxResults, firstResult);
    }

    private List<TareasProyecto> findTareasProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TareasProyecto.class));
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

    public TareasProyecto findTareasProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TareasProyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareasProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TareasProyecto> rt = cq.from(TareasProyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
