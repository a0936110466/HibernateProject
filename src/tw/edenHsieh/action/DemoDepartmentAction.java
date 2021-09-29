package tw.edenHsieh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.edenHsieh.model.Department;

public class DemoDepartmentAction {

	public static void main(String[] args) {
		StandardServiceRegistry	serviceRegistry =new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory= new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session =factory.openSession();
		session.beginTransaction(); //開交易
		
		Department dept= new Department(); 
		dept.setDeptname("RD");
		session.save(dept);
		
		session.getTransaction().commit(); //取得現在使用得交易物件並commit
		session.close();
		factory.close();
		
	}

}
