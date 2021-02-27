package dao.impl;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import dao.IUserDao;
import exception.EntityNotFoundException;
import model.User;

//@Repository

public class UserDimpl extends BaseDao implements IUserDao {

	@Transactional
	@Override
	public void insert(User model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(model);
	}

	@Transactional
	@Override
	public void update(User model) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);

	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		User model = (User) session.get(User.class, id);

		if (model != null) {
			session.delete(model);

		}

	}

	@Transactional(readOnly = true)
	@Override
	public User find(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		User model = (User) session.get(User.class, id);

		return model;

	}

	@Transactional(readOnly=true)
	@Override
	public User find(User user) throws EntityNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		
		User model = (User)session.createQuery("from User u where u.email = :email "
				+ " and u.password = :password")
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.uniqueResult();
		if(model==null) {
			throw new EntityNotFoundException();
		}
		return model;
	}

}
