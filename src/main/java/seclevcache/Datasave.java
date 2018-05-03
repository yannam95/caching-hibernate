package seclevcache;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Datasave {

	public static void main(String[] args) {
		Transaction tx =  null;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();
			
			Product prod1 = new Product();
			prod1.setName("mobile");
			prod1.setPrice(10000);
			prod1.setProduct_id(1);
			Product prod2 = new Product();
			prod2.setName("bluetoothspeaker");
			prod2.setPrice(2000);
			prod2.setProduct_id(2);
			
			session.persist(prod1);
			session.persist(prod2);
			
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}
}