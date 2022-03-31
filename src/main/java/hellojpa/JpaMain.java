package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    private static void createMember(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    private static void findMember(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = em.find(Member.class, 1L);

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    private static void updateMember(EntityManagerFactory emf, String name){
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = em.find(Member.class, 1L);
            member.setName(name);
//            이때 em.persist(member)로 저장하지 않아도 변경사항이 반영된다.
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    private static void jpqlFindMember(EntityManagerFactory emf, String name){
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            List<Member> members = em.createQuery("select m from Member", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(Member member: members)
                System.out.println(member.getName());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    private static void deleteMember(EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = em.find(Member.class, 1L);
            em.remove(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
        }
        emf.close();
    }

    public static void main(String[] args) {
        // entityManagerFactory는 어플리케이션 실행 시에 단 한번만 생성되어야한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
//        createMember(emf);
    }
}
