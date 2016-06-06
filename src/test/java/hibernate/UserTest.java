package hibernate;

/**
 * Created by hp on 2016/6/5.
 */


import edu.just.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserTest {
    private SessionFactory sessionFactory;
    @Before
    public void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        System.out.print("222");
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            System.out.print("223");
        } catch (Exception e) {
            System.out.print("error");
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @Test
    public void testBasicUsage() {
        // create a couple of events...
        System.out.print("hhh");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save( new User( 4,"hibernate","just2016","123456789","496759926" ) );
        session.save( new User( 5,"hibernate","just2016","123456789","496759926" ) );
        session.getTransaction().commit();
        session.close();

        // now lets pull events from the database and list them
        session = sessionFactory.openSession();
        session.beginTransaction();
            List result = session.createQuery( "from User" ).list();
        for ( User user : (List<User>) result ) {
            System.out.println( "Event (" + user.getName() + ") : " + user.getPassWord() );
        }
        session.getTransaction().commit();
        session.close();
    }
}