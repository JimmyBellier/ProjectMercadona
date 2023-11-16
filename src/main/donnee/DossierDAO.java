package igpde.gestion.donnee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import igpde.gestion.domaine.Dossier;


public final class DossierDAO extends AbstractDAO {

	private static DossierDAO instance = new DossierDAO();
	private DossierDAO() {
		// constructeur privé
	}
	public static DossierDAO getInstance() {
		return instance;
	}

	public Dossier findDossier(String numdossier)
	{
		Dossier d = null;
		EntityManager em = null;
		try
		{
			em = HibernateUtilJPA.currentEntityManager();		
			em.getTransaction().begin();
			
			Query q = em.createQuery("From Dossier d where d.numdossier=:numdos");
			q.setParameter("numdos", numdossier);
			
			d = (Dossier)q.getSingleResult();
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
		
		
		return d;
		
	}
}
