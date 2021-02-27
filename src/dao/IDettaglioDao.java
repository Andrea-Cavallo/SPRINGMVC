package dao;

import java.util.List;

import model.Dettaglio;

public interface IDettaglioDao {

	public void insert(Dettaglio model);

	public void update(Dettaglio model);

	public void delete(int id);

	public Dettaglio find(int id);

	public List<Dettaglio> findAll();
	
	
	
}
