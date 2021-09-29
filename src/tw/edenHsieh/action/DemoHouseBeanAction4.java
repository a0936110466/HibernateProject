package tw.edenHsieh.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
					
			//crateQuery查詢多筆資料
			Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class); //(hql語法,型別)
			List<HouseBean> resultlist = query.list();
			
				//1.
			for(HouseBean house:resultlist) {
				System.out.println(house.getHouseid()+":"+house.getHousename());	
			}
			
			System.out.println("=================");
			
				//2.
			Iterator<HouseBean> il = resultlist.iterator();
			while(il.hasNext()) {
				HouseBean resultBean = il.next();
			System.out.println(resultBean.getHouseid()+":"+resultBean.getHousename());
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
