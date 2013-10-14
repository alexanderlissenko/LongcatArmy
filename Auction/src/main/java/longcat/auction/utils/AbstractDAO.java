package longcat.auction.utils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * A container for entities, base class for OrderBook, ProductCatalogue,
 * CustomerRegistry The fundamental common operations are here (CRUD).
 *
 * T is type for items in container K is type of id (primary key)
 *
 * @author hajo
 */
public abstract class AbstractDAO<T , K> {
    
    private EntityManagerFactory emf;
    private Class<T> clazz;
    
    protected AbstractDAO(Class<T> clazz, String puName)
    {
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }


    
    public void add(T t) {
        EntityManager em = null;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
        finally {
        if (em != null) {
                em.close();  // ... and destroy
            }
        }
    }

    
    public void remove(K id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            T t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
    public T update(T t) {
        EntityManager em = null;
        T temp = null;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            temp = em.merge(t);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if (em != null) {
                em.close();  // ... and destroy
            }
        }
        return temp;
        
    }

    
    public T find(K id) {
       EntityManager em = emf.createEntityManager();
       return em.find(clazz, id);
    }

    
    public List<T> getRange(int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<T> found = new ArrayList<T>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.setMaxResults(nItems);
            q.setFirstResult(first);
            found.addAll(q.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return found;
    }

    public int getCount() {
        EntityManager em = emf.createEntityManager();
        int count = -1;
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(clazz);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            count = ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return count;
    }
    
    public List<T> getByName(String name)
    {
        EntityManager em = emf.createEntityManager();
        List<T> found = new ArrayList<T>();
         try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.getParameterValue(name);
            found.addAll(q.getResultList());
            
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
         
        return null;  
    }
    
    
}
