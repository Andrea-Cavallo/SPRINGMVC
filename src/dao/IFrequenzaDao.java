package dao;

import java.util.List;

import model.Frequenza;

public interface IFrequenzaDao {
	public void insert(Frequenza model);

	public void update(Frequenza model);

	public void delete(int id);

	public Frequenza find(int id);
	
	public List<Frequenza> findByIdStudente(int id);

	public List<Frequenza> findAll();

}
