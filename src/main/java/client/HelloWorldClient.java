package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			// Start the transaction
			txn.begin();

			// Creating objects
			// Message message = new Message("the_real_stew_pickels is a good username");
			// session.save(message);
			
			// Finding objects
			// Message message = (Message) session.get(Message.class, 2L);
			// System.out.println(message.toString());
			
			// Updating objects
			// Message message = (Message) session.get(Message.class, 2L);
			// message.setText("Hello automatic dirty checking");
			
			// Deleting objects
			Message message = (Message) session.get(Message.class, 3L);
			session.delete(message);

			// Commit Transaction
			txn.commit();
		} catch (Exception ex) {
			if (txn != null) { // Once transaction is committed, should equal null
				ex.printStackTrace();
			}
		} finally {
			if (session != null) { // Once session is closed, should equal null
				session.close();
			}
		}
	}
}
