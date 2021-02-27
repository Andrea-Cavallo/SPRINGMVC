package dao.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import dao.IStudenteDao;
import exception.EntityNotFoundException;
import model.Studente;

//@Repository
public class StudenteDImpl extends BaseDao implements IStudenteDao {

	@Transactional
	@Override
	public void insert(Studente model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(model);

	}

	@Transactional
	@Override
	public void update(Studente model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
//		model.setNome("prova"); tt le modifiche in automatico vengono rip se si strova nello stato Touched attaccato 
		// e' il metodo di session che rende touched o untouched -
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Studente model = (Studente) session.get(Studente.class, id);

		if (null != model) {

			session.delete(model);
		}

	}

	@Transactional(readOnly = true)

	@Override
	public Studente find(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Studente model = (Studente) session.get(Studente.class, id);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)

	@Override
	public List<Studente> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Studente> models = session.createQuery("from Studente").list();
		return models;
	}

	@Transactional(readOnly = true)

	@SuppressWarnings("unchecked")
	@Override
	public List<Studente> findAllByName(String nomeCercato) throws EntityNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();

		Query q = session.createQuery(" from Studente s where s.nome like :nome");
		q.setParameter("nome", nomeCercato + "%");
		List<Studente> models = q.list();

		if (models == null) {
			throw new EntityNotFoundException();
		}

		return models;
	}
	@Transactional(readOnly = true)

	@SuppressWarnings("unchecked")
	@Override
	public List<Studente> findAllBySurname(String cognomeCercato) throws EntityNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();

		Query q = session.createQuery(" from Studente s where s.cognome like :cognome");
		q.setParameter("cognome", cognomeCercato + "%");
		List<Studente> models = q.list();

		if (models == null) {
			throw new EntityNotFoundException();
		}

		return models;
	}

}
