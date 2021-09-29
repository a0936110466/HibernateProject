package tw.edenHsieh.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.model.HouseBeanService;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseBeanServiceAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//使用service呼叫DAO方法
			HouseBeanService hService=new HouseBeanService(session);
			List<HouseBean> resultList = hService.selectAll();
			System.out.println("resultList:"+resultList);
			
			
		for(HouseBean hBean:resultList) {
			System.out.println(hBean.getHouseid()+":"+hBean.getHousename());
		}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
