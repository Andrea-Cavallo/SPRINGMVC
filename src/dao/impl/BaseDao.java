package dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
	
	
		protected SessionFactory sessionFactory;
		
		@Autowired
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
	}
