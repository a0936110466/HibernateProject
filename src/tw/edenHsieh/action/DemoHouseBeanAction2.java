package tw.edenHsieh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
			
			//save新增
			HouseBean hBean2 = new HouseBean();
			hBean2.setHouseid(1003);
			hBean2.setHousename("My House");
			session.save(hBean2);
			
			//load查詢
			HouseBean resultBean = session.load(HouseBean.class, 1003);
			//如果資料庫無資料，則會丟出exception、rollback，則不會新增成功
			System.out.println(resultBean.getHouseid()+":"+resultBean.getHousename());
			
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
