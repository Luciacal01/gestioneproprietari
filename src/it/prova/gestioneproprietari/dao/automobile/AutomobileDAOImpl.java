package it.prova.gestioneproprietari.dao.automobile;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore input");
		}

		automobileInstance = entityManager.merge(automobileInstance);

	}

	@Override
	public void insert(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore input");
		}

		entityManager.persist(automobileInstance);

	}

	@Override
	public void delete(Automobile automobileInstance) throws Exception {
		if (automobileInstance == null) {
			throw new Exception("Problema valore input");
		}

		entityManager.remove(automobileInstance);
	}

	@Override
	public List<Automobile> findAllByCodiceFiscaleContiene(String StringaDaVerificare) throws Exception {
		TypedQuery<Automobile> query = entityManager.createQuery(
				"select a from Automobile a join a.proprietario p where p.codiceFiscale like ?1", Automobile.class);
		return query.setParameter(1, "%" + StringaDaVerificare + "%").getResultList();
	}

	@Override
	public List<Automobile> findAllByAutomobiliConErrore() throws Exception {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -18);
		Date date = c.getTime();

		TypedQuery<Automobile> query = entityManager.createQuery(
				"Select a from Automobile a join a.proprietario p where p.dataNascita >= ?1", Automobile.class);
		return query.setParameter(1, date).getResultList();
	}

}
