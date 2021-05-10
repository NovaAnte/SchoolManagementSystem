package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EducationDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
