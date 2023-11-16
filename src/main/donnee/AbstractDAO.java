package igpde.gestion.donnee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public abstract class AbstractDAO {

	public AbstractDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public Object saveOrUpdate(Object objet)
	{
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();		
			em.getTransaction().begin();
			em.persist(objet);
			em.getTransaction().commit();
		}
		catch (PersistenceException pe)
		{
			pe.printStackTrace();
			em.getTransaction().rollback();
			
		}
		finally
		{
			//em.close();
		}
		return objet;
	}
	
	public List find (String requeteHQL)
	{
		List result = null;
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();	
			em.getTransaction().begin();
			
			Query q = em.createQuery(requeteHQL);
			
			result = q.getResultList();
			em.getTransaction().commit();
		}
		catch (PersistenceException pe)
		{
			em.getTransaction().rollback();
			pe.printStackTrace();
		}
		finally
		{
			//em.close();
		}
		
		return result;
	}
	public void delete(Object objet)
	{
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();		
			em.getTransaction().begin();
			//em.remove(objet);
			em.remove(em.contains(objet) ? objet : em.merge(objet));
			em.getTransaction().commit();
		}
		catch (PersistenceException pe)
		{
			em.getTransaction().rollback();
			pe.printStackTrace();
		}
		finally
		{
			//em.close();
		}
		
	}
	

}
