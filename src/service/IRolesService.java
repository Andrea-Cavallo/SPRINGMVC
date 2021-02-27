package service;

import model.Roles;

public interface IRolesService {
	

	public void insert(Roles model);

	public void update(Roles model);

	public void delete(int id);

	public Roles find(int id);

}
