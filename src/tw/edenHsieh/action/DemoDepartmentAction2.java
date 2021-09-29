package tw.edenHsieh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Department;
import tw.edenHsieh.util.HibernateUtil;

public class DemoDepartmentAction2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session =factory.openSession();
		session.beginTransaction();
		
		Department dept= new Department();
		dept.setDeptname("HR");
		session.save(dept);
		
		session.getTransaction().commit(); //取得現在使用得交易物件的權限並關閉
		session.close();
		HibernateUtil.closeSessionFactory();
		
	}

}
