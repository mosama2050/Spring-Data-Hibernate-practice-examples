package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.jdbc.Driver;
import com.springdata.hibernate.model.Client;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			
				.addAnnotatedClass(Client.class)		
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		

		try {

			session.beginTransaction();
			Client c =  new Client("new" ,55,"cairo");
			c.setId((long)1);
			session.update(c);
			session.getTransaction().commit();

//			update  data
//			session.beginTransaction();
//			Client c =  session.get(Client.class,c);
//			c.setFullName("z3eem");
//			c.setAge(11);
//			c.setAddress("egy");
//			session.getTransaction().commit();
//

//          get data
//			session.beginTransaction();
//			Client c =  session.get(Client.class,(long)2);
//			session.getTransaction().commit();
//			System.out.println(c.toString());

//			save data
//			session.beginTransaction();
//			Client c = new Client("smsm" ,23,"cairo");
//			session.save(c);
//			session.getTransaction().commit();

//			save data
//			session.beginTransaction();
//			Client c = new Client();
//			c.setFullName("Yasser");
//			c.setAge(19);
//			c.setAddress("alex");
//			c.setId((long)1);
//			session.save(c);
//			session.getTransaction().commit();



// 			delete data
//			Client c = new Client();
//			c.setId(id);
//			session.delete(c);
//			session.getTransaction().commit();
			
			//System.out.println(c.getFullName() + " " + c.getAddress());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			session.close();
		}
		
	}

}

/*String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
String username = "eslam";
String password = "eslam";

try {
	Connection connection = DriverManager.getConnection(
			url, username ,password
			);
	System.out.println("Connected !");
	System.out.println(connection);
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e.toString());
}
*/