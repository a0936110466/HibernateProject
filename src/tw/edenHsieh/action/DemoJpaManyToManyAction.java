package tw.edenHsieh.action;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Game;
import tw.edenHsieh.model.Role;
import tw.edenHsieh.util.HibernateUtil;

public class DemoJpaManyToManyAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Game game = new Game();
			game.setGamename("Medal of Honor");

			Role role1 = new Role();
			role1.setRolename("sniper");
			role1.setSkill("shoot");
			
			Role role2 = new Role();
			role2.setRolename("troop");
			role2.setSkill("throw a grenade");
			
			Set<Role> roleList=new HashSet<Role>();
			roleList.add(role1);
			roleList.add(role2);
			
			game.setRoles(roleList);
			
			session.save(game);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
