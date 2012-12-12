package example.hibernate_search_solr_integration_example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: avner
 * Date: 12/3/12
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonCRUDMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config-spring-hibernate.xml");
        PersonCRUD personCRUD = new PersonCRUD();
        personCRUD.run();
    }

}
