package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IFrequenzaDao;
import model.Frequenza;
import service.IFrequenzaService;
//@Service

public class FrequenzaSimpl implements IFrequenzaService {

	private IFrequenzaDao frequenzaDao;

	@Autowired(required = true)
	public void setFrequenzaDao(IFrequenzaDao frequenzaDao) {
		this.frequenzaDao = frequenzaDao;
	}

	@Override
	public void insert(Frequenza model) {
		frequenzaDao.insert(model);
	}

	@Override
	public void update(Frequenza model) {
		frequenzaDao.update(model);
	}

	@Override
	public void delete(int id) {
		frequenzaDao.delete(id);

	}

	@Override
	public Frequenza find(int id) {
		return frequenzaDao.find(id);
	}

	@Override
	public List<Frequenza> findAll() {
		return frequenzaDao.findAll();
	}

	@Override
	public List<Frequenza> findByIdStudente(int id) {
		return frequenzaDao.findByIdStudente(id);
	}

}
