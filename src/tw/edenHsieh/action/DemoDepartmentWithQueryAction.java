package tw.edenHsieh.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.edenHsieh.model.Department;
import tw.edenHsieh.util.HibernateUtil;

public class DemoDepartmentWithQueryAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//使用HQL查詢多筆資料
			Query<Department> query = session.createQuery("from Department", Department.class);
			List<Department> lists = query.list();
			
			for(Department dept:lists) {
				System.out.println(dept.getDeptid()+":"+dept.getDeptname());
			}
			
			System.out.println("----------------------------");
			
			//使用HQL查詢單筆資料
			Query<Department> query2 = session.createQuery("from Department where deptid=3", Department.class);
			Department resultBean = query2.uniqueResult();
			if(resultBean !=null) {
				System.out.println(resultBean.getDeptid()+":"+resultBean.getDeptname());
			}else {
				System.out.println("No Result");
			}
			
			System.out.println("----------------------------");
			
			//使用"名字參數"查詢資料
			Query<Department> query3 = session.createQuery("from Department where deptid=:did and deptname=:dname", Department.class);			
			query3.setParameter("did", 5);
			query3.setParameter("dname", "QA");
			Department resultBean2 = query3.uniqueResult();
			if(resultBean2 != null) {
				System.out.println(resultBean2.getDeptid()+":"+resultBean2.getDeptname());
			}else {
				System.out.println("No Result 2");
			}
			
			System.out.println("----------------------------");
			
			//count查詢資料筆數
			Query query4 = session.createQuery("Select count(*) from Department");			
			Long count =(Long) query4.uniqueResult();
			System.out.println("Count:"+count);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
