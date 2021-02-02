package testdb;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getSf;

public class testHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory sf=getSf()){
			System.out.println("Hello");
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
