package example.hibernate_search_solr_integration_example;


import example.hibernate_search_solr_integration_example.application.Person;
import example.hibernate_search_solr_integration_example.application.PersonDAO;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/config-spring-hibernate.xml")
public class PersonDAOTest {
	@PersistenceContext
	private EntityManager entityManager;

    @Autowired
    PersonDAO personDAO;

    public void addPerson() {
        Person person = new Person();
        person.setName("Avner");
        person.setAge((short)4);
        personDAO.addPerson(person);
    }
	
	@Test @Transactional
	public void retrieveAccount() {
        addPerson();
		Query query = entityManager.createQuery("select p from Person p");
		Person person = (Person) query.getSingleResult();

		Assert.assertEquals(person.getName(), "Avner");
	}
	
	@Test @Transactional
	public void updateAccount() {
        addPerson();
        Query query = entityManager.createQuery("select p from Person p");
		Person a = (Person) query.getSingleResult();
		a.setName("foo");
	}

}
