package schoolmanagementsystem.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    private int credit;
    @ManyToOne
    private Education education;
    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;
    @Basic (fetch = FetchType.EAGER)
    private List<String> teacherNames;

    public Course() {
    }

    public Course(String name, int credit) {
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
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

    public void setTeachersNames(List<Teacher> teachers) {
        
        List<String> teacherNames = teachers.stream().map(t -> t.getName()).collect(Collectors.toList());
          
        this.teacherNames = teacherNames;
                
    }

    @Override
    public String toString() {
        setTeachersNames(teachers);
        return "Course{" + "id=" + id + ", name=" + name + ", credit=" + credit + ", teachers=" + teacherNames + '}';
    }



}