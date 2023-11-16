package igpde.gestion.donnee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import igpde.gestion.domaine.Dossier;
import igpde.gestion.domaine.Redevance;

public final class RedevanceDAO extends AbstractDAO {

	private static RedevanceDAO instance = new RedevanceDAO();
	private RedevanceDAO() {
		// constructeur privé
	}
	public static RedevanceDAO getInstance() {
		return instance;
	}

	public Redevance findRedevance(String libelle)
	{
		Redevance r = null;
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();		
			em.getTransaction().begin();
			
			Query q = em.createQuery("From Redevance r where r.libelle=:lib");
			q.setParameter("lib", libelle);
			
			r = (Redevance)q.getSingleResult();
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
		
		
		return r;
		
	}
}
