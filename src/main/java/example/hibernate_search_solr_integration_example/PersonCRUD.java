package example.hibernate_search_solr_integration_example;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: avner
 * Date: 12/3/12
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Configurable(autowire = Autowire.BY_TYPE)
public class PersonCRUD {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    private void addEntity() {
        Person person = new Person();
        person.setId(1L);
        person.setName("David");
        personDAO.addPerson(person);
    }

    @Transactional
    private void printPeople() {
        for (Person person : personDAO.getPeople())
            System.out.println(person);
    }

    public void run() {
        addEntity();
        printPeople();
    }
}


