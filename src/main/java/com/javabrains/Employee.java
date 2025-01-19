package com.javabrains;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(unique = true,nullable = false,length = 10,updatable = false)
    private String ssn;

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
}
