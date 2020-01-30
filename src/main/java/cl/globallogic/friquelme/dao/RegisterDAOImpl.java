package cl.globallogic.friquelme.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cl.globallogic.friquelme.entity.User;

@Repository
@Transactional
public class RegisterDAOImpl implements RegisterDAO{

	Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(User user) {
		logger.info("RegisterDAO::insert");
		entityManager.persist(user);
	}
}
