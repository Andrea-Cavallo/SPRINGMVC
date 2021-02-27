package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import dao.IStudenteDao;
import exception.EntityNotFoundException;
import model.Studente;
import service.IStudenteService;
//@Service

public class StudenteSImpl implements IStudenteService {

	private IStudenteDao studenteDao;

	@Autowired(required = true)
	public void setStudenteDao(IStudenteDao studenteDao) {
		this.studenteDao = studenteDao;
	}

	@Override
	public void insert(Studente model) {
		studenteDao.insert(model);
	}

	@Override
	public void update(Studente model) {
		studenteDao.update(model);
	}

	@Override
	public void delete(int id) {
		studenteDao.delete(id);
	}

	@Override
	public Studente find(int id) {
		return studenteDao.find(id);
	}

	@Override
	public List<Studente> findAll() {
		return studenteDao.findAll();
	}

	@Override
	public List<Studente> findAllByName(String nomeCercato) throws EntityNotFoundException {
		return studenteDao.findAllByName(nomeCercato);
	}

	@Override
	public List<Studente> findAllBySurname(String cognomeCercato) throws EntityNotFoundException {
		return studenteDao.findAllBySurname(cognomeCercato);
	}

}
