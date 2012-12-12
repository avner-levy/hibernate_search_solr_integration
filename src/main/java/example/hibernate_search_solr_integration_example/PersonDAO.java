package example.hibernate_search_solr_integration_example;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: avner
 * Date: 12/3/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PersonDAO {
    @PersistenceContext
    private EntityManager em;

    void addPerson(Person person) {
        em.persist(person);
    }

    List<Person> getPeople() {
        return em.createNamedQuery(Person.ALL_PEOPLE_QUERY).getResultList();
    }
}
