package com.javabrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarterRead {
        public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        /*//Lazy fetch check
        Employee employee=entityManager.find(Employee.class,1);
        System.out.println("****************** Fetched Employee");
        System.out.println(employee.getName());
        System.out.println(employee.getCard());

         */
            /*
        AccessCard card=entityManager.find(AccessCard.class, 3);
//        System.out.println(card);
        System.out.println(card.getOwner());

             */
            /*
//            PayStub payStub=entityManager.find(PayStub.class, 5);
//            System.out.println(payStub);
            Employee employee=entityManager.find(Employee.class,1);
            System.out.println(employee.getPayStubList());
            */

            /*System.out.println("*********** Before Fetching Employee");
            Employee employee=entityManager.find(Employee.class,1);
            System.out.println("*********** Before Accessing paystub");
            System.out.println(employee.getPayStubList());
            */

            EmailGroup emailGroup=entityManager.find(EmailGroup.class,7);
            System.out.println("Got Email Group. Now Accessing  members");
            System.out.println(emailGroup.getMembers());

    }
}
