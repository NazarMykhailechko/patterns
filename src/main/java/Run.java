import org.apache.log4j.Logger;
import soccer.org.model.Country;
import soccer.org.model.Result;
import soccer.org.model.Tournament;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    private static final Logger LOGGER = Logger.getLogger(Run.class);
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        LOGGER.info("Creating entityManager");
        entityManagerFactory = Persistence.createEntityManagerFactory("soccer");
        entityManager = entityManagerFactory.createEntityManager();

        Country country = new Country(1,"England");
        Country country2 = new Country(2,"Germany");
        Country country3 = new Country(3,"France");
        Country country4 = new Country(4,"Italy");
        Country country5 = new Country(5,"Spain");

        Tournament tournament1 = new Tournament(12,country,"Premier league",true);
        Tournament tournament2 = new Tournament(22,country2,"Bundes League",true);
        Tournament tournament3 = new Tournament(45,country4,"Serie A",true);
        Tournament tournament4 = new Tournament(57,country5,"Primeira",true);
        Tournament tournament5 = new Tournament(15,country3,"League 1",true);
        Tournament tournament6 = new Tournament(16,country,"ChampionShip",true);
        Tournament tournament7 = new Tournament(17,country5,"Segunda",true);

        Result result = new Result(tournament1,"Чемпионат: Англия Премьер лига - 2012/ 2013",
                "10-й тур","03.11.2012","Вест Хэм","Ман Сити",
                0,0);
        Result result2 = new Result(tournament1,"Чемпионат: Англия Премьер лига - 2012/ 2013",
                "10-й тур","03.11.2012","МЮ","Арсенал",
                2,1);
        Result result3 = new Result(tournament2,"Чемпионат: Германия Бундеслига - 2012/ 2013",
                "11-й тур","10.11.2012","Бавария","Вердер",
                2,0);
        Result result4 = new Result(tournament2,"Чемпионат: Германия Бундеслига - 2012/ 2013",
                "11-й тур","10.11.2012","Шальке","Арсенал",
                2,1);
        Result result5 = new Result(tournament6,"Чемпионат: Англия Чемпионшип - 2012/ 2013",
                "28-й тур","19.01.2013","Бирмингем","Брайтон",
                2,2);

        entityManager.getTransaction().begin();

        try{
            LOGGER.info("Saving data to Soccer DATABASE");

 /*           entityManager.persist(country);
            entityManager.persist(country2);
            entityManager.persist(country3);
            entityManager.persist(country4);
            entityManager.persist(country5);*/

/*            entityManager.persist(tournament1);
            entityManager.persist(tournament2);
            entityManager.persist(tournament3);
            entityManager.persist(tournament4);
            entityManager.persist(tournament5);
            entityManager.persist(tournament6);
            entityManager.persist(tournament7);*/

            entityManager.persist(result);
            entityManager.persist(result2);
            entityManager.persist(result3);
            entityManager.persist(result4);
            entityManager.persist(result5);

            entityManager.getTransaction().commit();
        }catch (Exception e){
            LOGGER.error("Information wasn't saved!!!", e);
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
