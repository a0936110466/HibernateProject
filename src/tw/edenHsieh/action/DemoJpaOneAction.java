package tw.edenHsieh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Book;
import tw.edenHsieh.model.BookDetail;
import tw.edenHsieh.util.HibernateUtil;

public class DemoJpaOneAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Book book = new Book();
			book.setBookname("Harry Potter");
			book.setAuthor("J.K.Rowling");
			book.setPrice(450);
			
			BookDetail bDetail = new BookDetail();
			bDetail.setPublisher("Bloomsbury");
			bDetail.setPublisheraddress("UK");
			
			book.setBookDetail(bDetail);
			bDetail.setBook(book);
			
			session.save(book);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
