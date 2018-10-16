package json;

import javax.persistence.*;
import java.io.IOException;

public class TestCurr {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("currdb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try{

            CurrUtiles.getCurrencies().forEach(entityManager::persist);

            transaction.commit();
            Query query = entityManager.createNamedQuery("GetRateMoreThan19");//createQuery("SELECT c FROM CurrencyRate AS c WHERE c.rate >19.5");
            query.getResultList().forEach(System.out::println);
        }catch (Exception e){
             e.printStackTrace();
        }finally {
            entityManager.close();
        }

        entityManager.close();
    }
}
