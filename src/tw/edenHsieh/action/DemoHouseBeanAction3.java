package tw.edenHsieh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
					
			//get查詢
			HouseBean resultBean = session.get(HouseBean.class, 1002);
			//如資料不存在--->null
			if(resultBean !=null) {				
				System.out.println(resultBean.getHouseid()+":"+resultBean.getHousename());
			}else {
				System.out.println("no result");
			}
			
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
