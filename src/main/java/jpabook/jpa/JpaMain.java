package jpabook.jpa;

import jpabook.jpa.domain.Address;
import jpabook.jpa.domain.Member;
import jpabook.jpa.domain.Period;

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
            member.setName("hello");
            member.setHomeAddress(new Address("city", "street", "12345"));
            member.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));
            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
