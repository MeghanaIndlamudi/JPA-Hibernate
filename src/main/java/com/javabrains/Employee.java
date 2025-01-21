package com.javabrains;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javabrains.AccessCard;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)//by default it is auto
    @GeneratedValue
    private int id;
    @Column(
            name = "employee_name",
            length = 100
    )
    private String name;

    private int age;

//    @Temporal(TemporalType.TIME)
    @Temporal(TemporalType.DATE)//to customize date
    private Date dob;

    @Column(unique = true,nullable = false,length = 10,updatable = false)
    private String ssn;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Transient
    private String debugString; // This field will not be persisted in the database

    @OneToOne//(fetch = FetchType.LAZY)
    private AccessCard card;

    @OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
    private List<PayStub> payStubList = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", type=" + type +
                ", card=" + card +
                '}';
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<PayStub> getPayStubList() {
        return payStubList;
    }

    public void setPayStubList(List<PayStub> payStubList) {
        this.payStubList = payStubList;
    }

    public void addPayStub(PayStub payStub){
        this.addPayStub(payStub);
    }
}
