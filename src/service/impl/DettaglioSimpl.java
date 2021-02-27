package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.IDettaglioDao;
import model.Dettaglio;
import service.IDettaglioService;

public class DettaglioSimpl implements IDettaglioService {
	private IDettaglioDao dettaglioDao;

	@Autowired(required = true)
	public void setDettaglioDao(IDettaglioDao dettaglioDao) {
		this.dettaglioDao = dettaglioDao;
	}

	@Override
	public void insert(Dettaglio model) {
		dettaglioDao.insert(model);

	}

	@Override
	public void update(Dettaglio model) {
		dettaglioDao.update(model);
	}

	@Override
	public void delete(int id) {
		dettaglioDao.delete(id);
	}

	@Override
	public Dettaglio find(int id) {
		return dettaglioDao.find(id);
	}

	@Override
	public List<Dettaglio> findAll() {
		return dettaglioDao.findAll();
	}

}
