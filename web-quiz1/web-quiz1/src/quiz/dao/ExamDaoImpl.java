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

public class ExamDaoImpl implements ExamDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Exam> getExamList() {		
		Session session = sessionFactory.getCurrentSession();
		Query<Exam> query = session.createQuery("from Exam" , Exam.class);
		List<Exam> Exams = query.getResultList();
		return Exams;
	}

	@Override
	@Transactional
	public Exam getExam(int eid) {
	System.out.println("in getExam of exam DAo");
	Session session = sessionFactory.getCurrentSession();
		Exam exam=session.get(Exam.class, eid);
		System.out.println(exam);
		return exam;
	}

	@Override
	@Transactional
	public boolean addExam(Exam exam) {
		System.out.println("in addExam of exam DAo");
		System.out.println(exam);
		Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(exam);
			System.out.println(exam);
			return true;
			
	}
	
	@Override
	@Transactional
	public boolean UpdateExam(Exam exam) {
		System.out.println("in addExam of exam DAo for update");
		System.out.println(exam.getExamID());
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(exam);
		return true;
			
	}
	
	@Override
	@Transactional
	public boolean deleteExam(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Exam where examID=:theId");
		query.setParameter("theId", theId);
		try {
		query.executeUpdate();
		return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	@Override
	@Transactional
	public Exam getExamforUpdate(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Exam exam = session.get(Exam.class, theId);
		return exam;
	
	}
}
