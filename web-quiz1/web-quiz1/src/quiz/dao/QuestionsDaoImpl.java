package quiz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quiz.entity.Exam;
import quiz.entity.Questions;

@Repository
public class QuestionsDaoImpl implements QuestionsDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Questions> getQuestions() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Questions> query = session.createQuery("from Questions" , Questions.class);
		List<Questions> questions = query.getResultList();
		
		return questions;
	}
	@Override
	@Transactional
	public List<Questions> getQuestions(Exam exam) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Questions> query = session.createQuery("from Questions where exam=:exam" , Questions.class);
		query.setParameter("exam", exam);
		List<Questions> questions = query.getResultList();
		
		return questions;
	}

	@Override
	@Transactional
	public void addQuestion(Questions theQuestion) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theQuestion);
		
	}

	@Override
	@Transactional
	public Questions getQuestionforUpdate(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Questions theQuestion = session.get(Questions.class, theId);
		return theQuestion;
	
	}
	
	@Override
	@Transactional
	public void deleteQuestion(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Questions where que_id=:questionID");
		query.setParameter("questionID", theId);
		query.executeUpdate();
		
	}

}
