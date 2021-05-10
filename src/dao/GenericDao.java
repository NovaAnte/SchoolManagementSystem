package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
