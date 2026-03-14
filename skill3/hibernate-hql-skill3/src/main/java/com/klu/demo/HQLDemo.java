package com.klu.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.klu.entity.Product;
import com.klu.loader.ProductDataLoader;
import com.klu.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();


        System.out.println("----- Sorting by Price -----");

        Query<Product> q1 = session.createQuery("from Product order by price", Product.class);
        List<Product> list1 = q1.list();

        for(Product p : list1){
            System.out.println(p.getName()+" "+p.getPrice());
        }

        System.out.println("----- Filtering Price > 100 -----");

        Query<Product> q2 = session.createQuery("from Product where price > 100", Product.class);
        List<Product> list2 = q2.list();

        for(Product p : list2){
            System.out.println(p.getName()+" "+p.getPrice());
        }

        System.out.println("----- Pagination -----");

        Query<Product> q3 = session.createQuery("from Product", Product.class);
        q3.setFirstResult(0);
        q3.setMaxResults(3);

        List<Product> list3 = q3.list();

        for(Product p : list3){
            System.out.println(p.getName());
        }

        System.out.println("----- Aggregate Function -----");

        Query<Long> q4 = session.createQuery("select count(*) from Product", Long.class);
        Long total = q4.uniqueResult();

        System.out.println("Total Products = " + total);

        session.close();
        factory.close();
    }
}