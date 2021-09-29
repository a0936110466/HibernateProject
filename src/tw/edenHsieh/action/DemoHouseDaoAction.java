package tw.edenHsieh.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.HouseBean;
import tw.edenHsieh.model.HouseBeanDao;
import tw.edenHsieh.util.HibernateUtil;

public class DemoHouseDaoAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			HouseBeanDao hDao = new HouseBeanDao(session);
			
			//執行查詢單筆
			HouseBean resultBean = hDao.selectById(1001);
			if(resultBean!=null) {
				System.out.println(resultBean.getHouseid()+":"+resultBean.getHousename());
			}else {
				System.out.println("No result");
			}
			
			System.out.println("------------------------------");
			
			
//			HouseBean saveBean= new HouseBean();
//			saveBean.setHouseid(1004);
//			saveBean.setHousename("Your House");
//			hDao.insert(saveBean);
			
			//更新資料
//			hDao.update(1001, "Funny House");
			
			//刪除資料
			hDao.deleteById(1003);
			
			//執行查詢多筆
			List<HouseBean> resultList = hDao.selectAll();
			
			for(int i=0;i<resultList.size();i++) {
				HouseBean hBean = resultList.get(i);
				System.out.println((i+1)+"."+hBean.getHouseid()+":"+hBean.getHousename());
			}
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
