package tw.edenHsieh.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanAction6 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
			HouseBean updateBean=new HouseBean();
			updateBean.setHouseid(1003);
			updateBean.setHousename("Nice House");
			
				//針對id更改資料
			session.update(updateBean);
			
			session.getTransaction().commit();
			System.out.println("Transaction Commit");
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction RollBack");
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	
	}

}
