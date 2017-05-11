package ua.com.model;

import javax.persistence.*;

/**
 * Created by oleg on 30.04.17.
 */

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSONID")
    private int personId;

    @Column(name = "PERSONNAME")
    private String personName;

    @Column(name = "PDATAIL_FK")
    private int pDetailFk;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private PersonDetail detail;

    public PersonDetail getDetail() {
        return detail;
    }

    public Person(String personName, int pDetailFk) {
        this.personName = personName;
        this.pDetailFk = pDetailFk;
    }

    public Person() {

    }

    public void setDetail(PersonDetail detail) {
        this.detail = detail;
    }

    public int getpDetailFk() {
        return pDetailFk;
    }

    public void setpDetailFk(int pDetailFk) {
        this.pDetailFk = pDetailFk;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (personId != person.personId) return false;
        if (pDetailFk != person.pDetailFk) return false;
        if (personName != null ? !personName.equals(person.personName) : person.personName != null) return false;
        return detail != null ? detail.equals(person.detail) : person.detail == null;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (personName != null ? personName.hashCode() : 0);
        result = 31 * result + pDetailFk;
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\npersonId=" + personId +
                "\npersonName='" + personName +
                "\npDetailFk=" + pDetailFk;
    }
}
