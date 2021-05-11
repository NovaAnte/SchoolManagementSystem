package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Education;

public class EducationDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void addEducation(String name) {
        EntityManager em = emf.createEntityManager();

        Education e = new Education(name);

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    void removeEducation(int id) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, id);

        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        em.close();
    }

    void showAllEducations() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> query = em.createQuery("SELECT e FROM Education e", Education.class);
        List<Education> educations = query.getResultList();

        for (Education education : educations) {
            System.out.println(education);
        }
        em.close();
    }

    void updateEducation(int id, String newName) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, id);

        em.getTransaction().begin();
        if (!newName.isBlank()) {
            e.setName(newName);
        }

        em.getTransaction().commit();
        em.close();

    }

    void showEducationInfo(int id) {
        EntityManager em = emf.createEntityManager();

        Education e = em.find(Education.class, id);

        System.out.println(e);

        em.close();
    }

}
