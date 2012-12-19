package example.hibernate_search_solr_integration_example.application;

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
        person.setName("David");
        person.setAge((short)45);
        person.setComments("I'm a very nice person");
        personDAO.addPerson(person);
    }

    @Transactional
    private void updateEntities() {
        // Lets add one year to everyone age
        for (Person person : personDAO.getPeople())
            person.setAge((short)(person.getAge()+1));
    }

    @Transactional
    private void printPeople() {
        System.out.println("All people known:");
        for (Person person : personDAO.getPeople())
            System.out.println("Person: "+ person);
    }

    public void run() {
        addEntity();
        printPeople();
        updateEntities();
        printPeople();
    }
}


