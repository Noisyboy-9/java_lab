package lab.votingSystem;

import java.util.Objects;

/**
 * A person can that make a vote
 */
public class Person {
    private String name;

    /**
     * Instantiates a new Person with firstname and lastname as separate arguments.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Person(String firstName, String lastName) {
        this(firstName + " " + lastName);
    }

    /**
     * Instantiates a new Person with input name as a whole string.
     *
     * @param name the name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Get person name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
