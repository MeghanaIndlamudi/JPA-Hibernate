package com.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAPersistenceContextDemo
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setName("New Employee");
        employee.setSsn("12345");
        employee.setAge(26);
        employee.setDob(new Date());
        employee.setType(EmployeeType.FULL_TIME);
        System.out.println("********************************Created employee Instance");
        // syntax to Get an Entity manager to manage data holder which is an entity. get it and tell it save this entry
        //name is in the persistence.xml which can be changed to anything adding it as a local variable
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        System.out.println("********************************Starting Transaction ");
        entityManager.persist(employee);
        System.out.println("********************************After Persist method called ");

        Employee employeeFound=entityManager.find(Employee.class,1);
        System.out.println(employee);
        System.out.println(employeeFound);
        System.out.println(employee==employeeFound);

        transaction.commit();
        System.out.println("********************************After Transaction closed");
        entityManager.close();
        entityManagerFactory.close();
    }
}
