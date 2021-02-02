package quiz.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quiz.entity.Exam;
import quiz.entity.Reports;
import quiz.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public User validateLogin(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		User userFound = null;
		Query query = session.createQuery("select u from User u where u.email=:n and u.password=:pass");
		query.setParameter("n", email);
		query.setParameter("pass", password);
		
		try {
			userFound = (User) query.getSingleResult();
			System.out.println("\n\n***********	UID = " + userFound.getId() + " **********\n\n");

		} catch (NoResultException e) {
			e.printStackTrace();

			return userFound;
		}
		
			System.out.println("\n\n***********	UID = " + userFound.getId() + " **********\n\n");
		
		return userFound;

	}
	
	@Override
	@Transactional
	public boolean register(User newUser) {
		System.out.println("in register daoimpl");
		boolean mesg = false;
		//line throws error
		Session session=sessionFactory.getCurrentSession();
		System.out.println("afetr getting current session");
		session.save(newUser);
		System.out.println("after query");
		System.out.println("newUser"+newUser);
		mesg=true;
		return mesg;			
	}

	@Override
	@Transactional
	public User getUserByid(int id) {
		Session session = sessionFactory.getCurrentSession();
		User exam=session.get(User.class, id);
		System.out.println(exam);
		return exam;
	
	}

	@Override
	@Transactional
	public boolean updateMail(int id,String email) {
		Session session = sessionFactory.getCurrentSession();
		User u=session.get(User.class, id);
		u.setEmail(email);
		System.out.println(u);
		session.saveOrUpdate(u);
		return true;
	}

	@Override
	@Transactional
	public boolean updatePassword(int id,String password) throws GeneralSecurityException, IOException {
		Session session = sessionFactory.getCurrentSession();
		User u=session.get(User.class, id);
		u.setPassword(password);	
		System.out.println(u);
		session.saveOrUpdate(u);
		return true;
	
		
	}
}
