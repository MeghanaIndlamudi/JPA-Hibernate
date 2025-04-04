package com.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class JPAStarterWrite
{
    public static void main( String[] args )
    {
        /*read
        //To use update or validate or none in hbm2ddl value
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        // just like table name in JPA we give entity class name
        //this is equal to select * from employee_daa where id=1;
        Employee employee=entityManager.find(Employee.class, 1);
        Employee employee1=entityManager.find(Employee.class, 2);
        Employee employee2=entityManager.find(Employee.class, 3);
        System.out.println(employee);
        System.out.println(employee1);
        System.out.println(employee2);

         */
        /*
        //update
        employee1.setAge(30);
        employee1.setType(EmployeeType.FULL_TIME);
        // doing the above 2 lines doesn;t help we need to tell persist or JPA that we need to update

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        // In the below line if employee already exist it recognizes as update else it will insert. This will be identified using primary key
        entityManager.persist(employee1);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
         */
        /*
        // If data doesn't exists in java it returns a null in sql it is empty
        Employee employee4=entityManager.find(Employee.class, 4);
        System.out.println(employee4);
        */
        /*
        //delete
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(employee2);// find employee instance and pass it to remove

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

         */

        Employee employee = new Employee();
//        employee.setId(1);
        employee.setName("Meghana");
        employee.setSsn("123");
        employee.setAge(24);
        employee.setDob(new Date());
        employee.setType(EmployeeType.CONTRACTOR);

        Employee employee1 = new Employee();
//        employee1.setId(2);
        employee1.setName("Sai");
        employee1.setAge(26);
        employee1.setSsn("1234");
        employee1.setType(EmployeeType.CONTRACTOR);

//        Employee employee2 = new Employee();
////        employee2.setId(3);
//        employee2.setName("Dharani");
//        employee2.setAge(27);
//        employee2.setSsn("12345");
//        employee2.setType(EmployeeType.CONTRACTOR);

        AccessCard accessCard1=new AccessCard();
        accessCard1.setIssuesDate(new Date());
        accessCard1.setiActive(true);
        accessCard1.setFirmwareVersion("1.0.0");
        accessCard1.setOwner(employee);
        employee.setCard(accessCard1);


        AccessCard accessCard2=new AccessCard();
        accessCard2.setIssuesDate(new Date());
        accessCard2.setiActive(false);
        accessCard2.setFirmwareVersion("1.2.0");
        accessCard2.setOwner(employee1);
        employee1.setCard(accessCard2);

        PayStub payStub=new PayStub();
        payStub.setPayPeriodStart(new Date());
        payStub.setGetPayPeriodEnd(new Date());
        payStub.setEmployee(employee);
        employee.addPayStub(payStub);
        payStub.setSalary(1000);


        PayStub payStub1=new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setGetPayPeriodEnd(new Date());
        payStub1.setEmployee(employee1);
        employee1.addPayStub(payStub1);
        payStub1.setSalary(2000);

        EmailGroup group=new EmailGroup();
        group.setName("Company Watercooler Discussions");
        group.addMember(employee);
        group.addMember(employee1);
        employee.addEmailSubscription(group);
        employee1.addEmailSubscription(group);

        EmailGroup group1=new EmailGroup();
        group1.setName("Company Project Discussions");
        group1.addMember(employee);
        employee.addEmailSubscription(group1);

//        employee.setPayStubList(List.of(payStub,payStub1));

        // syntax to Get an Entity manager to manage data holder which is an entity. get it and tell it save this entry
        //name is in the persistence.xml which can be changed to anything adding it as a local variable
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(employee1);
//        entityManager.persist(employee2);

        entityManager.persist(accessCard1);
        entityManager.persist(accessCard2);

        entityManager.persist(payStub);
        entityManager.persist(payStub1);

        entityManager.persist(group);
        entityManager.persist(group1);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
