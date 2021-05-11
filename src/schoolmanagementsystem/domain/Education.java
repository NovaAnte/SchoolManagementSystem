package schoolmanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Education {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @Basic
    private int totalCredit;
    @OneToMany(mappedBy = "education")
    private List<Course> courses;
    @OneToMany(mappedBy = "education")
    private List<Student> students;

    public Education() {
    }

    public Education(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit() {
        int totalCreadit = 0;
        List<Course> courses = getCourses();
        for (Course c : courses) {
            totalCreadit += c.getCredit();
        }
        this.totalCredit = totalCredit;
    }

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.setEducation(this);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.setEducation(null);
    }

    public List<Student> getStudents() {
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        getStudents().add(student);
        student.setEducation(this);
    }

    public void removeStudent(Student student) {
        getStudents().remove(student);
        student.setEducation(null);
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", name=" + name + ", totalcredit=" + totalCredit + '}';
    }

}
