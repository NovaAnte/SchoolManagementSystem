package schoolmanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @Basic
    private String credit;
    @ManyToOne
    private Education education;
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    public Course() {
    }

    public Course(String name, String credit) {
        this.name = name;
        this.credit = credit;
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

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<Teacher> getTeachers() {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        getTeachers().add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        getTeachers().remove(teacher);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", credit=" + credit + '}';
    }

}