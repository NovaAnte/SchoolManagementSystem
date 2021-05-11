package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import schoolmanagementsystem.domain.Course;
import schoolmanagementsystem.domain.Education;
import schoolmanagementsystem.domain.Student;
import schoolmanagementsystem.domain.Teacher;

public class GenericDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    void showAllTeachersInCourse(int id) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> x = em.createQuery("SELECT a FROM Teacher a WHERE a.courses.id=:id", Teacher.class);
        x.setParameter("id", id);
        List<Teacher> t = x.getResultList();

        for (Teacher teacher : t) {
            System.out.println(teacher);
        }
    }

    void disconnectTeacherFromCourse(int teacherId, int courseId) {
        EntityManager em = emf.createEntityManager();

        Teacher x = em.find(Teacher.class, teacherId);
        Course c = em.find(Course.class, courseId);

        em.getTransaction().begin();
        x.removeCourse(c);
        em.getTransaction().commit();
        em.close();
    }

    void connectTeacherToCourse(int teacherId, int courseId) {
        EntityManager em = emf.createEntityManager();

        Teacher x = em.find(Teacher.class, teacherId);
        Course c = em.find(Course.class, courseId);

        em.getTransaction().begin();
        x.addCourse(c);
        em.getTransaction().commit();
        em.close();
    }

    void showAllStudentsInEducation(int eduId) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> x = em.createQuery("SELECT a FROM Student a WHERE a.education.id=:eduId", Student.class);
        x.setParameter("eduId", eduId);
        List<Student> s = x.getResultList();

        for (Student student : s) {
            System.out.println(student);
        }
    }

    void disconnectStudentFromEducation(int stuId) {
        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, stuId);

        em.getTransaction().begin();
        s.setEducation(null);
        em.getTransaction().commit();
        em.close();
    }

    void connectStudentToEducation(int stuId, int eduId) {
        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, stuId);
        Education edu = em.find(Education.class, eduId);

        em.getTransaction().begin();
        s.setEducation(edu);
        em.getTransaction().commit();
        em.close();
    }

    void disconnectCourseFromEducation(int courseId, int eduId) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, courseId);
        Education edu = em.find(Education.class, eduId);

        em.getTransaction().begin();
        edu.removeCourse(c);
        em.getTransaction().commit();
        em.close();
    }

    void showAllCoursesInEducation(int eduId) {
        EntityManager em = emf.createEntityManager();

        Education edu = em.find(Education.class, eduId);
        Object[] list = edu.getCourses().toArray();

        for (Object object : list) {
            System.out.println(object);
        }
        
    }

    void connectCourseToEducation(int courseId, int eduId) {
        EntityManager em = emf.createEntityManager();
        
        Course c = em.find(Course.class, courseId);
        Education edu = em.find(Education.class, eduId);
        
        em.getTransaction().begin();
        edu.addCourse(c);
        em.getTransaction().commit();
        em.close();
    }

}
