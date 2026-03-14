package com.klu.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Dell Laptop",50000,10);

        session.save(p1);

        tx.commit();
        session.close();

        System.out.println("Product inserted successfully");
    }
}