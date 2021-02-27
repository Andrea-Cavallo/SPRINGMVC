package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.IRolesDao;
import model.Roles;
import service.IRolesService;

//@Service
public class RolesSimpl implements IRolesService {

	private IRolesDao rolesDao;

	@Autowired(required = true)
	public void setRolesDao(IRolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}
	@Transactional

	@Override
	public void insert(Roles model) {
		rolesDao.insert(model);

	}
	@Transactional

	@Override
	public void update(Roles model) {
		rolesDao.update(model);
	}
	@Transactional

	@Override
	public void delete(int id) {
		rolesDao.delete(id);
	}
	@Transactional(readOnly = true)

	@Override
	public Roles find(int id) {
		return rolesDao.find(id);
	}

}
