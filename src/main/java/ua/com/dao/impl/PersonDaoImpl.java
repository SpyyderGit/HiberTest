package ua.com.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.com.dao.PersonDao;
import ua.com.model.Person;

import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by oleg on 30.04.17.
 */
public class PersonDaoImpl implements PersonDao {

    private Session session;
    private Transaction transaction;

    public PersonDaoImpl(Session session) {
        this.session = session;
    }

    @Transactional
    public void addPerson(String name, int pDetailPk) {
        transaction = session.beginTransaction();
        session.save(new Person(name, pDetailPk));
        transaction.commit();
        session.close();

    }

    @Transactional
    public void deletePerson(int id) {
        Person person = getPerson(id);
        transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();
    }


    @Transactional
    public void updatePerson(Person person) {
        transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    public List<Person> getAllPersons() {
        List<Person> personList = session.createQuery("from Person").list();
        return personList;
    }

    public Person getPerson(int id) {
        Query query = session.createQuery("from Person");
        List<Person> persons = query.list();
        Person getPerson = null;
        for (Person person : persons) {
            if (person.getPersonId() == id) {
                getPerson = new Person(person.getPersonName(), person.getpDetailFk());
                getPerson.setPersonId(person.getPersonId());
            }
        }
        return getPerson;
    }
}
