package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Teacher;

public class TeacherDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    
    
    void removeTeacher( int id) {
        
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, id);
        
        if(teacher == null) {
            
            System.out.println("No such Teacher!");
            
        } else {
           
            em.getTransaction().begin();
            em.remove(teacher);
            em.getTransaction().commit();
            
        }
        em.close();  
    }
    
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
        
        if(teacher == null) {
            
            System.out.println("No teacher found!");
            
        } else {
            
            System.out.println(teacher);
        }
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
        
        if(teacher == null) {
            System.out.println("No teacher found!");
        }
        else {
        
            em.getTransaction().begin();
        
            if(!name.isBlank())
                teacher.setName(name);
        
            if(!gender.isBlank())
                teacher.setGender(gender);
        
            if(!Double.isNaN(salary)) // -------- Får testa om denna funkar...
                teacher.setSalary(salary);
        
            if(!(age == 0))
                teacher.setAge(age);
        
            if(!email.isBlank())
                teacher.setEmail(email);
        
        
            em.getTransaction().commit();
        
        }
        
        em.close();
    }

}
