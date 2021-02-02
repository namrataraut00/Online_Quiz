package quiz.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quiz.entity.Reports;
@Repository

public class ReportDaoImpl implements reportDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean addEntry(int sid, int eid,String name,String ename ,String lang,String marks,LocalDate date,char flag) {

		Reports reportentry = new Reports(sid, eid, marks,date,flag,name,ename,lang);

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(reportentry);
		System.out.println(reportentry);
		return true;
	}

	@Override
	@Transactional

	public List<Reports> getbyExamID(int eid) {
		List<Reports> reportlist = new ArrayList<Reports>();
		String jpql = "select u from Reports u where u.eid=:rl";
		 reportlist=sessionFactory.getCurrentSession().createQuery(jpql, Reports.class).setParameter("rl", eid).getResultList();
		return reportlist;
	}

	@Override
	@Transactional

	public boolean clearAll() {
		String jpql = "truncate table Reports";
		 sessionFactory.getCurrentSession().createQuery(jpql, Reports.class);
		
		return true;
	}

	@Override
	@Transactional
	public List<Reports> getTopper(int eid) {
		List<Reports> reportlist = new ArrayList<Reports>();
		String jpql = "select u from Reports u where u.eid=:rl order by marks desc";
		
		 reportlist=sessionFactory.getCurrentSession().createQuery(jpql, Reports.class).setParameter("rl", eid).setMaxResults(2).getResultList();
		
		 return reportlist;
}

	@Override
	@Transactional
	public List<Reports> getallExamsForId(int id) {
		List<Reports> reportlist = new ArrayList<Reports>();
		String jpql = "select u from Reports u where u.sid=:rl";
		
		 reportlist=sessionFactory.getCurrentSession().createQuery(jpql, Reports.class).setParameter("rl", id).getResultList();
		
		 return reportlist;
		
	}

}
