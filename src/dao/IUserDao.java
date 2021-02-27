package dao;

import exception.EntityNotFoundException;
import model.User;

public interface IUserDao {

	public void insert(User model);

	public void update(User model);

	public void delete(int id);

	public User find(int id);
	public User find(User user) throws EntityNotFoundException ;

}
