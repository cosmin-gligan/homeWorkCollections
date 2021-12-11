package ro.siit;

import ro.siit.collections.model.CollegeEnum;
import ro.siit.collections.model.Student;
import ro.siit.service.HobbiesService;

public class Main {
    /*
     1. Define for Hobby a class that contains:
        -Name of hobby (String) – eq: cycling, swimming
        -Frequency (int) – how many times a week they practice it
        -List of Addresses where this hobby can be practiced (List<Address>)

    2. Use a HashMap<Student, List<Hobby>>, don't forget about equals/hashcode. Add some information to this map.

    3. For a certain Student , print the names of the hobbies and the cities where it can be practiced

    4. Implement an algorithm to determine the collection of students that share a particular hobby
        Collection<Student> findStudentsWithHobby(Hobby hobby, Map<Student, List<Hobby>> studentHobbies)

    5. Implement an algorithm to determine which students exist in two collections
        Collection<Student> findIntersection(Collection<Student> c1, Collection<Student> c2)
        This can be used together with findStudentsWithHobby to determine which students share two (and even more) hobbies
    */
    public static void main(String[] args) {

        HobbiesService.startApp();

    }
}
