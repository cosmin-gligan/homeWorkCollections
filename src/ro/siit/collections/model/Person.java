package ro.siit.collections.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected int cnp;
    protected int age;
    protected String gender;

    public Person(String firstName, String lastName, int cnp, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.age = age; //in viitor facem metoda sa extragem varsta din CNP
        this.gender = getGenderForCnp(cnp); // am extras sexul din CNP
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

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @NotNull
    private String getGenderForCnp(int cnp) {

        int firstDigit = Integer.parseInt(String.valueOf(cnp).substring(0, 1));

        if (firstDigit == 1 || firstDigit == 5) {
            return "M";
        }

        if (firstDigit == 2 || firstDigit == 6){
            return "F";
        }
        //intoarcem ? daca nu am reusit sa determinam sexul ( in viitor exception )
        return "?";
    }

    //folosim CNP-ul pt. a determina egalitatea
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getCnp() == person.getCnp();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnp());
    }

    //am facut metoda abstracta, fortam "copii" sa-si implementeze propriile lor versiuni
    public abstract String toString();
}
