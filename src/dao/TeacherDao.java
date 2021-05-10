package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
