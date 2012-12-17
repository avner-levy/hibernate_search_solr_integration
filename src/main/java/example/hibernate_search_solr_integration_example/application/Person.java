package example.hibernate_search_solr_integration_example.application;

import org.hibernate.annotations.Index;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.IndexedPropertyChangeEvent;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name=Person.ALL_PEOPLE_QUERY, query = "select p from Person p")
})
@Indexed
public class Person {

    public static final String ALL_PEOPLE_QUERY = "allPeople";

	private long id;
	
	private String name;

    private Short age;

    private String comments;

    private Set<Person> children = new HashSet<>();

    @Id
    @Field
    @GeneratedValue(strategy = GenerationType.TABLE)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    @NotNull
    @Column(nullable = false)
    @Field
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    @NotNull
    @Column(nullable = false)
    @Field
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Field
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    public Set<Person> getChildren() {
        return children;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (children != null ? !children.equals(person.children) : person.children != null) return false;
        if (comments != null ? !comments.equals(person.comments) : person.comments != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", comments='" + comments + '\'' +
                ", children=" + children +
                '}';
    }
}
