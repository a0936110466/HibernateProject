package tw.edenHsieh.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanAction5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
			
			HouseBean deleBean= new HouseBean();
			deleBean.setHouseid(1003);
			deleBean.setHousename("Nice House");
				//使用id刪除row，不設Housename也可刪除
			session.delete(deleBean);
			
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
