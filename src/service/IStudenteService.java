package service;

import java.util.List;

import exception.EntityNotFoundException;
import model.Studente;

public interface IStudenteService {
	
	
	public void insert(Studente model);

	public void update(Studente model);

	public void delete(int id);

	public Studente find(int id);

	public List<Studente> findAll();
	
	public List<Studente> findAllByName(String nomeCercato) throws EntityNotFoundException;
	public List<Studente> findAllBySurname(String cognomeCercato) throws EntityNotFoundException;

}
