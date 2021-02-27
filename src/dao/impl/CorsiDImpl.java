package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import dao.ICorsiDao;
import model.Corsi;
import model.Studente;

public class CorsiDImpl extends BaseDao implements ICorsiDao {
	@Transactional

	@Override
	public void insert(Corsi model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(model);

	}

	@Transactional

	@Override
	public void update(Corsi model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Transactional

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Corsi model = (Corsi) session.get(Corsi.class, id);

		if (null != model) {

			session.delete(model);
		}
	}

	@Transactional(readOnly = true)

	@Override
	public Corsi find(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Corsi model = (Corsi) session.get(Corsi.class, id);
		for (Studente s : model.getStudenti()) {
			System.out.println(s);

		}
		// cosi lo costringo a popolare e quindi mi evito l'eager perche' la sessione e'
		// ancora aopereta..

		return model;
	}

	@Transactional(readOnly = true)

	@SuppressWarnings("unchecked")
	@Override
	public List<Corsi> findAll() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Corsi> models = session.createQuery("from Corsi").list();

		for (Corsi m : models) {

			// cosi lo costringo a popolare e quindi mi evito l'eager perche' la sessione e'
			// ancora aopereta..
			// potevo evitarmi questo e usasre l .EAGER
		}

		return models;
	}

}
