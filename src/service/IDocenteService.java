package service;

import java.util.List;

import model.Docente;

public interface IDocenteService {
	
	public void insert(Docente model);

	public void update(Docente model);

	public void delete(int id);

	public Docente find(int id);

	public List<Docente> findAll();
}
