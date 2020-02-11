package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Address;
import entity.Guide;
import entity.Message;
import entity.Person;
import entity.Student;
import util.HibernateUtil;

public class HelloWorldClient {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			// Start the transaction
			txn.begin();

			/* BASIC CRUD OPERATIONS */
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
			// Message message = (Message) session.get(Message.class, 3L);
			// session.delete(message);
			
			/* MAPPING OPERATIONS */
//			Address homeAddress = new Address("299 E Main St", "Sioux City", "51104");
//			Address billingAddress = new Address("301 21st St", "Sioux City", "51104");
//			Person person = new Person("Will", homeAddress, billingAddress);
//			session.save(person);
			
			/* Many Students to one Guide */
//			Guide guide = new Guide("2000MO10789", "Toby Flenderson", 1000);
//			Student student = new Student("2014JT50123", "Johnny Bravo", guide);
//			Student student2 = new Student("2082NJ50138", "Brett Favre", guide);
//			
//			session.persist(student); // Will persist guide object with it
//			session.persist(student2);
			
			// Delete student by using CascadeType.REMOVE
			// When deleting student, delete guide as well, if not used by other student
			/*Student brett = session.get(Student.class, 3L);
			session.delete(brett);*/
			
			/* MANY TO ONE PERSISTENCE */
			Guide guide1 = new Guide("200238ME0281", "MATT MALLETT", 10000);
			Guide guide2 = new Guide("38238AWK2329", "BILLY RUBEN", 10023);
			
			Student student1 = new Student("238AKDK2929", "ZACH HICKS", guide1);
			Student student2 = new Student("2022NJ50138", "MARCELA MALLETT", guide2);
			
			guide1.getStudents().add(student1);
			guide2.getStudents().add(student2);
			
			// Since the guide has ManyToOne cascade persist, the student will be persisted alongside
			session.persist(guide1);
			session.persist(guide2);
			
			
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
