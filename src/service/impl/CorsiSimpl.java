package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ICorsiDao;
import model.Corsi;
import service.ICorsiService;
//@Service

public class CorsiSimpl implements ICorsiService {

	private ICorsiDao corsiDao;

	@Autowired(required = true)
	public void setCorsiDao(ICorsiDao corsiDao) {
		this.corsiDao = corsiDao;
	}

	@Override
	public void insert(Corsi model) {
		corsiDao.insert(model);

	}

	@Override
	public void update(Corsi model) {
		corsiDao.update(model);
	}

	@Override
	public void delete(int id) {
		corsiDao.delete(id);
	}

	@Override
	public Corsi find(int id) {
		return corsiDao.find(id);
	}

	@Override
	public List<Corsi> findAll() {
		return corsiDao.findAll();
	}

}
