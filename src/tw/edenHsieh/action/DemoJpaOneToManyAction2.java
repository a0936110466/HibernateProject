package tw.edenHsieh.action;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.edenHsieh.model.Stock;
import tw.edenHsieh.model.StockTransaction;
import tw.edenHsieh.util.HibernateUtil;

public class DemoJpaOneToManyAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Stock stock = new Stock();
			stock.setStockname("TSMC");
			stock.setStockcode("2330");
			
			//建立股票交易
			StockTransaction trans1 = new StockTransaction();
			StockTransaction trans2 = new StockTransaction();
			StockTransaction trans3 = new StockTransaction();
			
			//設定股票交易量
			trans1.setTradevolume(13000);
			trans2.setTradevolume(25000);
			trans3.setTradevolume(18000);
			
			//StockTransaction加入stock
			trans1.setStock(stock);
			trans2.setStock(stock);
			trans3.setStock(stock);
			
			//Linked 按照順序存入set(LinkedHashSet)
			Set<StockTransaction> stockTrans= new LinkedHashSet<StockTransaction>();
			stockTrans.add(trans1);
			stockTrans.add(trans2);
			stockTrans.add(trans3);
			
			//stock加入StockTransaction
			stock.setStockTrans(stockTrans);
			
			session.save(stock);
			
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
