package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import dao.IUserDao;
import exception.EntityNotFoundException;
import model.User;
import service.IUserService;

//@Service

public class UserSimpl implements IUserService {

	private IUserDao userDao;

	@Autowired(required = true)
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void insert(User model) {
		userDao.insert(model);

	}

	@Override
	public void update(User model) {
		userDao.update(model);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User find(int id) {
		return userDao.find(id);
	}

	@Override
	public User find(User user) throws EntityNotFoundException {
		return userDao.find(user);
	}

}
