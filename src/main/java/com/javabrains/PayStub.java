package com.javabrains;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PayStub {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

@Column(name = "start_date")
    private Date payPeriodStart;

@Column(name = "end_date")
    private Date getPayPeriodEnd;

    private float salary;

    @ManyToOne
    @JoinColumn(name = "paystub_for")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public Date getGetPayPeriodEnd() {
        return getPayPeriodEnd;
    }

    public void setGetPayPeriodEnd(Date getPayPeriodEnd) {
        this.getPayPeriodEnd = getPayPeriodEnd;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PayStub{" +
                "id=" + id +
                ", payPeriodStart=" + payPeriodStart +
                ", getPayPeriodEnd=" + getPayPeriodEnd +
                ", salary=" + salary +
                ", employee=" + employee +
                '}';
    }

}
