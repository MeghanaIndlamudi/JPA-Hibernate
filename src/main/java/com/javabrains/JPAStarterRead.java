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
        AccessCard card=entityManager.find(AccessCard.class, 3);
//        System.out.println(card);
        System.out.println(card.getOwner());
    }
}
