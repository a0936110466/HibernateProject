package tw.edenHsieh.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Department;
import tw.edenHsieh.util.HibernateUtil;

public class DemoDepartmentAction4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession(); //會自動關閉連線(commit、rollback)，不必自己關連線(需於cfg.xml中設定)
		
		try {
			session.beginTransaction(); //開啟交易
			
			Department dept4 = new Department();
			dept4.setDeptname("QA");
			session.persist(dept4); 
			//不見得立刻將Primary Key值指定給Bean物件，有可能等到Session.flush()時才執行Insert
			session.flush();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
