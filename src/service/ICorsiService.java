package service;

import java.util.List;

import model.Corsi;


public interface ICorsiService {
	public void insert(Corsi model);

	public void update(Corsi model);

	public void delete(int id);

	public Corsi find(int id);

	public List<Corsi> findAll();

}
