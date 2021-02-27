package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import dao.IDettaglioDao;
import model.Corsi;
import model.Dettaglio;
import model.Frequenza;
import model.Studente;

// @Repository 
public class DettaglioDimpl extends BaseDao implements IDettaglioDao {
	@Transactional

	@Override
	public void insert(Dettaglio model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(model);
	}

	@Transactional

	@Override
	public void update(Dettaglio model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Transactional

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Dettaglio model = (Dettaglio) session.get(Dettaglio.class, id);
		if (model != null) {
			session.delete(id);
		}

	}

	@Transactional(readOnly = true)

	@Override
	public Dettaglio find(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Dettaglio where idstudente = :ids");
		q.setInteger("ids", id);
		Dettaglio model = (Dettaglio) q.uniqueResult();

//		Session session = this.sessionFactory.getCurrentSession();
//
//		Dettaglio model = (Dettaglio) session.get(Dettaglio.class, id);


		return model;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Dettaglio> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Dettaglio> models = session.createQuery("from Dettaglio").list();
		return models;
	}

}
