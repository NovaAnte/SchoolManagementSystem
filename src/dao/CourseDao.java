package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CourseDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
}
