package ua.com.model;

import javax.persistence.*;

/**
 * Created by oleg on 30.04.17.
 */

@Entity
@Table(name = "PERSON_DETAIL")
public class PersonDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAILID_PK")
    private int detailId;

    @Column(name = "INCOME")
    private double income;

    @Column(name = "JOB")
    private String job;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERSONID")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "PersonDetail{" +
                "detailId=" + detailId +
                ", income=" + income +
                ", job='" + job + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

