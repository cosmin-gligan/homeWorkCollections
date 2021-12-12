package ro.siit.service;

import ro.siit.collections.model.Hobby;
import ro.siit.collections.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

//folosesc o interfata sa ma asigur ca implementez toate metodele cerute in tema
public interface MinimumRequirements {
    void printStudentHobbies(Student student, Map<Student, List<Hobby>> studentHobbies);
    Collection<Student> findStudentsWithHobby(Hobby hobby, Map<Student, List<Hobby>> studentHobbies);
    Collection<Student> findIntersection(Collection<Student> c1, Collection<Student> c2);
}
