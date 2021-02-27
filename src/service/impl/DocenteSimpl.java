package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDocenteDao;
import model.Docente;
import service.IDocenteService;
//@Service

public class DocenteSimpl implements IDocenteService {

	private IDocenteDao docenteDao;

	@Autowired(required = true)
	public void setDocenteDao(IDocenteDao docenteDao) {
		this.docenteDao = docenteDao;
	}


	@Override
	public void insert(Docente model) {
		docenteDao.insert(model);

	}
	

	@Override
	public void update(Docente model) {
		docenteDao.update(model);
	}

	@Override
	public void delete(int id) {
		docenteDao.delete(id);
	}

	@Override
	public Docente find(int id) {
		return docenteDao.find(id);
	}

	@Override
	public List<Docente> findAll() {
		return docenteDao.findAll();
	}

}
