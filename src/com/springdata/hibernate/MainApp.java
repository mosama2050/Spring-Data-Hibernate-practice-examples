package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.jdbc.Driver;
import com.springdata.hibernate.model.Client;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class MainApp {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {


//			Criteria without sql query
			session.beginTransaction();
			Criteria c =session.createCriteria(Client.class);
// 			 c.add(Restrictions.eq("id" ,(long)2)); get one object
//			c.add(Restrictions.like("fullName" ,"s", MatchMode.ANYWHERE));


//			LogicalExpression or = Restrictions.and(obj1 , obj2);
//			c.add(or);

			
			List<Client> clients = c.list();
			System.out.println(clients);



//			session.beginTransaction();
//			Query q1 = session.createQuery("select MAX (id)from  Client ") ;
//			Query q2 = session.createQuery("select MIN (id)from  Client ") ;
//			Query q3 = session.createQuery("select avg (id)from  Client ") ;
//			Query q4 = session.createQuery("select sum (id)from  Client ") ;
//			Query q5 = session.createQuery("select count (id)from  Client ") ;
//
//
//			System.out.println(q1.list().get(0));
//			System.out.println(q2.list().get(0));
//			System.out.println(q3.list().get(0));
//			System.out.println(q4.list().get(0));
//			System.out.println(q5.list().get(0));



//get some data
//			session.beginTransaction();
//			Query q = session.createQuery("from  Client where  id=?1") ;
////			q.setFirstResult(0);
////			q.setMaxResults(3);
//			q.setInteger(1,1); // pointer frist question mark
//			List<Client> c =q.list();
//			System.out.println(c);
//			for (Client x : c) {
//				System.out.println(x.getFullName());
//
//			}

 /*   like 's%'    	start with s%
         	  		end   with %s
					any  %s%

*/
//        	get one
//			session.beginTransaction();
//			List<Client> c = session.createQuery("from  Client c where c.fullName='smsm' and  c.age=23 ").list();
//			List<Client> c = session.createQuery("from  Client c where c.fullName='smsm'").list();
//			System.out.println(c);
//			for (Client x : c) {
//				System.out.println(x.getFullName());
//			}




//        				get all
//            session.beginTransaction();
//            List<Client> c = session.createQuery("from  Client").list();
//            System.out.println(c);
//            for (Client x : c) {
//                System.out.println(x.getFullName());
//            }


//			update  data
//			session.beginTransaction();
//			Client c =  new Client("new" ,55,"cairo");
//			c.setId((long)1);
//			session.update(c);
//			session.getTransaction().commit();

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
//			Client c = new Client("zezo" ,11,"cairo");
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