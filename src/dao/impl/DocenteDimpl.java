package dao.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import dao.IDocenteDao;
import model.Docente;

public class DocenteDimpl extends BaseDao implements IDocenteDao {


	@Transactional
	@Override
	public void insert(Docente model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(model);
	}

	@Transactional
	@Override
	public void update(Docente model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Docente model = (Docente) session.get(Docente.class, id);

		if (null != model) {

			session.delete(model);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Docente find(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		Docente model = (Docente) session.get(Docente.class, id);
		return model;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Docente> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Docente> models = session.createQuery("from Docente").list();
		return models;
	}

}
