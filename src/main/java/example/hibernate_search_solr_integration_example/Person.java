package example.hibernate_search_solr_integration_example;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name=Person.ALL_PEOPLE_QUERY, query = "select p from Person p")
})
public class Person {

    public static final String ALL_PEOPLE_QUERY = "allPeople";

	private long id;
	
	private String name;

    @Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
	public String toString() {
		return  "id: " + id + ", name: " + name;
	}

}
