package com.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class JPAStarterMain
{
    public static void main( String[] args )
    {
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setName("Meghana");
        employee.setSsn("123");
        employee.setDob(new Date());
        employee.setType(EmployeeType.CONTRACTOR);

        Employee employee1 = new Employee();
//        employee1.setId(2);
        employee1.setName("Sai");
        employee1.setSsn("1234");
        employee1.setType(EmployeeType.CONTRACTOR);

        Employee employee2 = new Employee();
//        employee2.setId(3);
        employee2.setName("Dharani");
        employee2.setSsn("12345");

        // syntax to Get an Entity manager to manage data holder which is an entity. get it and tell it save this entry
        //name is in the persistence.xml which can be changed to anything adding it as a local variable
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        transaction.commit();
    }
}
