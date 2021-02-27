package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import dao.IFrequenzaDao;
import model.Frequenza;


//@Repository 
public class FrequenzaDImpl extends BaseDao implements IFrequenzaDao {


	@Override
	public void insert(Frequenza model) {

	}

	@Override
	public void update(Frequenza model) {

	}

	@Transactional
	@Override

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		Frequenza model = (Frequenza) session.get(Frequenza.class, id);
		// (load è diverso dal GET li tiene in vita sulla jvm ma il metodo load
		// restiuisce l oggetto e poi va a chiudere l oggetto
		if (null != model) {
			session.delete(model);
		}

	}

	@Override
	public Frequenza find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Frequenza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)

	@Override
	public List<Frequenza> findByIdStudente(int id) {

		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Frequenza where idstudenti = :ids");
		q.setInteger("ids",id);
		List<Frequenza> models = q.list();
		return models;
	}

}
