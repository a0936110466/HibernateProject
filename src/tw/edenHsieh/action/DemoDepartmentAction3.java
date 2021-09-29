package tw.edenHsieh.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Department;
import tw.edenHsieh.util.HibernateUtil;

public class DemoDepartmentAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession(); //會自動關閉連線(commit、rollback)，不必自己關連線(需於cfg.xml中設定)
		
		try {
			session.beginTransaction(); //開啟交易
			
			Department dept3 = new Department();
			dept3.setDeptname("Sales");
			Serializable resultDept = session.save(dept3);//回傳序號
			System.out.println("resultDept:"+resultDept); //resultDept:3(id)
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
