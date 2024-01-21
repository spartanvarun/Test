package domain;
//import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Persons extends PanacheEntity {

@NotNull
    private String firstname;

    @NotNull
    private String lastname;
    @NotNull
   private int age;
    public Persons() {
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Persons(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }


        public static List<Persons> findByFirstName(String firstName) {
            return list("SELECT p FROM Persons p WHERE p.firstname = ?1", firstName);
        }
    public static List<Persons> findByAge(int age) {
        return list("select p from Persons p where p.age=?1",age);
        //return list("age = :age", Parameters.with("age", age).map());
    }


}


