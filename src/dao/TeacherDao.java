package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Teacher;

public class TeacherDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    
    
    void addTeacher(String name, String gender, double salary, int age, String email) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = new Teacher(name, gender, salary, age, email);
        
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    void showTeacher(int id) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, id);
        
        System.out.println(teacher);
        em.close();
    }

    void showAllTeachers() {
        
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = query.getResultList();
        
        teachers.forEach(System.out::println);
        em.close();
    }

    void updateTeacher(int id, String name, String gender, double salary, int age, String email) {
        
        EntityManager em = emf.createEntityManager();
        
        Teacher teacher = em.find(Teacher.class, id);
        
        em.getTransaction().begin();
        
        if(!name.isBlank())
            teacher.setName(name);
        
        if(!gender.isBlank())
            teacher.setGender(gender);
        
        if(!Double.isNaN(salary))
            teacher.setSalary(salary);
        
        
        
        em.getTransaction().commit();
        em.close();
    }

}
