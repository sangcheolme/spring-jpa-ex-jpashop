package jpabook.jpa;

import jpabook.jpa.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("testName");
            member.setCity("Seoul");
            member.setStreet("Gangnam");
            member.setZipcode("12345");
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            order.setOrderDate(LocalDateTime.now());
            order.setStatus(OrderStatus.ORDER);
            em.persist(order);

            Book book = new Book();
            book.setName("testItem");
            book.setPrice(10000);
            book.setStockQuantity(10);
            book.setIsbn("1234");
            book.setAuthor("testAuthor");
            em.persist(book);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(book);
            orderItem.setOrderPrice(10000);
            orderItem.setCount(1);
            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
