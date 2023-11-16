package igpde.gestion.donnee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import igpde.gestion.domaine.Element;
import igpde.gestion.domaine.Redevance;

public class ElementDAO extends AbstractDAO  {
	
	private static ElementDAO instance=new ElementDAO();
	private ElementDAO() {
		//constructeur prive
	}
	public static ElementDAO getInstance() {
		
		return instance;
	}
	
	public Element findElement(String nom) {
		Element e = null;
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();		
			em.getTransaction().begin();
			
			Query q = em.createQuery("From Element e where e.nom = :nom");
			q.setParameter("nom", nom);
			
			e = (Element)q.getSingleResult();
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
		return e;	
		
	}
}
