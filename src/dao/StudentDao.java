package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Student;

public class StudentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void removeStudent(int id) {
        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, id);

        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        em.close();
    }

    void showAllStudents() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> x = em.createQuery("SELECT a FROM Student a", Student.class);
        List<Student> s = x.getResultList();

        for (Student student : s) {
            System.out.println(student);
        }

        em.close();
    }

    boolean showStudent(int id) {
        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, id);
        if (s == null) {

            System.out.println("No teacher found!");
            return false;
        } else {
            System.out.println(s);
        }
        em.close();
        return true;
    }

    void updateStudent(int id, String newName, String newGender, int newAge, String newEmail) {
        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, id);

        em.getTransaction().begin();
        if (!newName.isBlank()) {
            s.setName(newName);
        }
        s.setGender(newGender);
        if (newAge != 0) {
            s.setAge(newAge);
        }
        if (!newEmail.isBlank()) {
            s.setEmail(newEmail);
        }
        em.getTransaction().commit();
        em.close();
    }

    void addStudent(String name, String gender, int age, String email) {
        EntityManager em = emf.createEntityManager();

        Student s = new Student(name, gender, age, email);

        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

}
