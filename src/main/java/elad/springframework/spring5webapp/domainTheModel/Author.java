package elad.springframework.spring5webapp.domainTheModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* based on : https://www.baeldung.com/jpa-entities*/

@Entity/*Entities in JPA represent a table stored in a database*//*מסמל ישות */
public class Author {
    @Id /*אנוטציה זאת תגיד לטבלה מהו המפתח הראשי *//*defines the primary key*/
    @GeneratedValue(strategy = GenerationType.AUTO)/*specify GenerationType.AUTO, the JPA provider will use any strategy it wants to generate the identifiers.*/
    /*We can choose from four id generation strategies with the strategy element. The value can be AUTO, TABLE, SEQUENCE, or IDENTITY.*/
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<>();

    /*all arg con*/

    public Author( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    /*no args con*/
    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
