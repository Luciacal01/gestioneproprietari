package it.prova.gestioneproprietari.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Proprietario propprietarioInstance) throws Exception {
		if (propprietarioInstance == null) {
			throw new Exception("problema valore in input");
		}
		entityManager.persist(propprietarioInstance);
	}

	@Override
	public void delete(Proprietario o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int countProprietariwhitAutoImmatricolataDal(int annoImmatricolazione) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
