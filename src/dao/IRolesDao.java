package dao;

import model.Roles;

public interface IRolesDao {

	public void insert(Roles model);

	public void update(Roles model);

	public void delete(int id);

	public Roles find(int id);

}
