package seclevcache;

import org.hibernate.Session;

public class CacheTest {

	public static void main(String[] args) throws Exception {
		Session session = null;
		final long startTime = System.currentTimeMillis();
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			Product pr1 = session.get(Product.class, 1);
			System.out.println(pr1);

			System.out.println("---------------------");
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}

		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			Product pr1 = session.get(Product.class, 1);
			System.out.println(pr1);
			long endTime   =System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("total time taken");
			System.out.println(totalTime);
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}