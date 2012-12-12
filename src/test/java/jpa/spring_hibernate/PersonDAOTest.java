package jpa.spring_hibernate;


import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
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
        person.setId(1L);
        person.setName("Avner");
        personDAO.addPerson(person);
    }
	
	@Test @Transactional
	public void retrieveAccount() {
        addPerson();
		Query query = entityManager.createQuery("from Person a where a.id=:id").setParameter("id", 1L);
		Person a = (Person) query.getSingleResult();
		Assert.assertEquals(a.getName(), "Avner");
	}
	
	@Test @Transactional
	public void updateAccount() {
        addPerson();
		Query query = entityManager.createQuery("from Person a where a.id=:id").setParameter("id", 1L);
		Person a = (Person) query.getSingleResult();
		a.setName("foo");
	}

}
