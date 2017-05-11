import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.com.dao.PersonDao;
import ua.com.dao.impl.PersonDaoImpl;
import ua.com.model.Person;
import ua.com.model.PersonDetail;

/**
 * Created by oleg on 30.04.17.
 */
public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        PersonDao personDao = new PersonDaoImpl(session);
//        personDao.addPerson("Karina", 1);
        System.out.println(personDao.getPerson(8));
//        personDao.deletePerson(2);

//        Person p = new Person("Oleg",0);
//        p.setPersonId(2);
//        personDao.updatePerson(p);
    }
}
