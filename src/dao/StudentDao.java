package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
