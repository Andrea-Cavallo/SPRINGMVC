package dao.impl;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import dao.IRolesDao;
import model.Roles;

//@Repository
public class RolesDimpl extends BaseDao implements IRolesDao {
	@Transactional
	@Override
	public void insert(Roles model) {
		Session session = this.sessionFactory.getCurrentSession();

		session.persist(model);

	}

	@Transactional
	@Override
	public void update(Roles model) {

		Session session = this.sessionFactory.getCurrentSession();

		session.update(model);

	}

	@Transactional
	@Override
	public void delete(int id) {

		Session session = this.sessionFactory.getCurrentSession();

		Roles model = (Roles) session.get(Roles.class, id);

		if (model != null) {
			session.delete(model);
		}

	}

	@Transactional(readOnly = true)
	@Override
	public Roles find(int id) {

		Session session = this.sessionFactory.getCurrentSession();

		Roles model = (Roles) session.get(Roles.class, id);
		return model;
	}

}
