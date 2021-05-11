package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Course;

public class CourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void removeCourse(int id) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);

        em.getTransaction().begin();
        if (c != null) {
            em.remove(c);
            em.getTransaction().commit();
        } else {
            System.out.println("No course found with that ID.");
        }
        em.close();
    }

    void showAllCourses() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> x = em.createQuery("SELECT a FROM Course a", Course.class);
        List<Course> c = x.getResultList();

        if (c.isEmpty()) {
            System.out.println("No courses added yet!");
        } else {
            for (Course course : c) {
                System.out.println(course);
            }
        }
        em.close();
    }

    boolean showCourseInfo(int id) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);

        if (c != null) {
            System.out.println(c);
            return true;
        } else {
            System.out.println("No course found with that ID.");
        }
        em.close();
        return false;
    }

    void updateCourse(int id, String newName, int newCredit) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, id);
        if (c != null) {
            em.getTransaction().begin();
            if (!newName.isBlank()) {
                c.setName(newName);
            }
            if (newCredit != 0) {
                c.setCredit(newCredit);
            }
            em.getTransaction().commit();
        } else
            System.out.println("No course found with that ID.");
        em.close();

    }

    void addCourse(String name, int credit) {
        EntityManager em = emf.createEntityManager();

        Course c = new Course(name, credit);

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

}
