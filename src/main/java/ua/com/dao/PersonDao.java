package ua.com.dao;

import ua.com.model.Person;

import java.util.List;

/**
 * Created by oleg on 30.04.17.
 */
public interface PersonDao {
    void addPerson(String name, int pDetailPk);

    void deletePerson(int id);

    void updatePerson(Person person);

    List<Person> getAllPersons();

    Person getPerson(int id);
}
