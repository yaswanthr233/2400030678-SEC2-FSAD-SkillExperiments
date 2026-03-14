package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop","Electronics",50000,10));
        session.save(new Product("Mouse","Electronics",500,50));
        session.save(new Product("Keyboard","Electronics",1500,30));
        session.save(new Product("Chair","Furniture",3000,15));
        session.save(new Product("Table","Furniture",7000,5));

        tx.commit();

        System.out.println("Products inserted");

        Query<Product> q1 = session.createQuery("from Product order by price asc", Product.class);

        List<Product> list1 = q1.list();
        System.out.println("Ascending Order");
        list1.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        Query<Product> q2 = session.createQuery("from Product order by price desc", Product.class);

        System.out.println("Descending Order");
        q2.list().forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        Query<Product> q3 = session.createQuery("from Product order by quantity desc", Product.class);

        System.out.println("Highest Quantity");
        q3.list().forEach(p -> System.out.println(p.getName()+" "+p.getQuantity()));

        Query<Product> q4 = session.createQuery("from Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);

        System.out.println("First 3 Products");
        q4.list().forEach(p -> System.out.println(p.getName()));

        Query<Product> q5 = session.createQuery("from Product", Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);

        System.out.println("Next 3 Products");
        q5.list().forEach(p -> System.out.println(p.getName()));

        Long count = (Long) session.createQuery("select count(*) from Product").uniqueResult();

        System.out.println("Total Products: "+count);

        Object[] price = (Object[]) session.createQuery("select min(price), max(price) from Product").uniqueResult();

        System.out.println("Min Price: "+price[0]);
        System.out.println("Max Price: "+price[1]);

        Query<Product> q6 = session.createQuery("from Product where price between 1000 and 10000", Product.class);

        System.out.println("Price between 1000 and 10000");
        q6.list().forEach(p -> System.out.println(p.getName()));

        Query<Product> q7 = session.createQuery("from Product where name like 'L%'", Product.class);

        System.out.println("Names starting with L");
        q7.list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }
}