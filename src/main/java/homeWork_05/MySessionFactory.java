package homeWork_05;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static final EntityManagerFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
            return entityManager;
        }
        return entityManager;
    }

    public static void closeManager() {
        entityManager.close();
    }
}
