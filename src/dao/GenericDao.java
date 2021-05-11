package dao;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
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
        edu.setTotalCredit();
        em.getTransaction().commit();
        em.close();

    }

    void showAllCoursesInEducation(int eduId) {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> x = em.createQuery("SELECT a FROM Course a WHERE a.education.id=:eduId", Course.class);
        x.setParameter("eduId", eduId);
        List<Course> c = x.getResultList();

        for (Course course : c) {
            System.out.println(course);
        }

        em.close();
    }

    void connectCourseToEducation(int courseId, int eduId) {
        EntityManager em = emf.createEntityManager();

        Course c = em.find(Course.class, courseId);
        Education edu = em.find(Education.class, eduId);

        em.getTransaction().begin();
        edu.addCourse(c);
        edu.setTotalCredit();
        em.getTransaction().commit();
        em.close();
    }

    void showStatistics() {
        EntityManager em = emf.createEntityManager();
        DecimalFormat df = new DecimalFormat("#.##");

        // --- Gender Statistics --- //
        TypedQuery<Student> x = em.createQuery("SELECT a FROM Student a", Student.class);
        System.out.println("=====Student Gender Statistics =====");
        List<Student> allStudents = x.getResultStream()
                .collect(Collectors.toList());

        if (!allStudents.isEmpty()) {

            // Percentage of female students
            List<Student> femaleStudents = x.getResultStream()
                    .filter(x1 -> x1.getGender().equals("Female"))
                    .collect(Collectors.toList());

            double sumFemaleStudents = ((double) femaleStudents.size() / allStudents.size()) * 100;
            System.out.println(df.format(sumFemaleStudents) + "% of the students are female");

            // Percentage of male students
            List<Student> maleStudents = x.getResultStream()
                    .filter(x2 -> x2.getGender().equals("Male"))
                    .collect(Collectors.toList());

            double sumMaleStudents = ((double) maleStudents.size() / allStudents.size()) * 100;
            System.out.println(df.format(sumMaleStudents) + "% of the students are male");

            // Percentage of non-binary students
            List<Student> nonBinaryStudents = x.getResultStream()
                    .filter(x3 -> x3.getGender().equals("Unknown"))
                    .collect(Collectors.toList());

            double sumNonBinaryStudents = ((double) nonBinaryStudents.size() / allStudents.size()) * 100;
            System.out.println(df.format(sumNonBinaryStudents) + "% of the students are non-binary");

        } else {
            System.out.println("There are no students!");
        }

        // --- Teacher Statistics --- //
        TypedQuery<Teacher> t = em.createQuery("SELECT a FROM Teacher a", Teacher.class);
        System.out.println("===== Teacher Gender Statistics =====");
        List<Teacher> allTeachers = t.getResultStream()
                .collect(Collectors.toList());

        if (!allTeachers.isEmpty()) {

            // Percentage of female teachers
            List<Teacher> femaleTeachers = t.getResultStream()
                    .filter(t1 -> t1.getGender().equals("Female"))
                    .collect(Collectors.toList());

            double sumFemaleTeachers = ((double) femaleTeachers.size() / allTeachers.size()) * 100;
            System.out.println(df.format(sumFemaleTeachers) + "% of the teachers are female");

            // Percentage of male teachers
            List<Teacher> maleTeachers = t.getResultStream()
                    .filter(t2 -> t2.getGender().equals("Male"))
                    .collect(Collectors.toList());

            double sumMaleTeachers = ((double) maleTeachers.size() / allTeachers.size()) * 100;
            System.out.println(df.format(sumMaleTeachers) + "% of the teachers are male");

            // Percentage of non-binary students
            List<Teacher> nonBinaryTeachers = t.getResultStream()
                    .filter(t3 -> t3.getGender().equals("Unknown"))
                    .collect(Collectors.toList());

            double sumNonBinaryTeachers = ((double) nonBinaryTeachers.size() / allTeachers.size()) * 100;
            System.out.println(df.format(sumNonBinaryTeachers) + "% of the teachers are non-binary");

        } else {
            System.out.println("There are no teachers!");
        }

    }

}
