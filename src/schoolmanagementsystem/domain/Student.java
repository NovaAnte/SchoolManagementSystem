package schoolmanagementsystem.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;
    @Basic
    private String gender;
    @Basic
    private int age;
    @Basic
    private String email;
    @ManyToOne
    private Education education;

    public Student() {
    }

    public Student(String name, String gender, int age, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        if (this.education == null) {
            return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", email=" + email + ", education=none" + '}';
        } else {
            return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", email=" + email + ", education=" + education.getName() + '}';

        }
    }

}
