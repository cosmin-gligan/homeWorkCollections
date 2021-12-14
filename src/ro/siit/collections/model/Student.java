package ro.siit.collections.model;

import java.util.Map;
import java.util.TreeMap;

public class Student extends Person {
    private String studentID; //numarul matricol
    private String college;

    //folosim constructorul din parinte
    public Student(String firstName, String lastName, String cnp, int age, String studentID, String college){
        super(firstName, lastName, cnp, age);
        this.studentID = studentID;
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student:" +
                "  Fullnane='" + getFullName() + '\'' +
                ", cnp='" + cnp +'\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", studentID='" + studentID + '\'' +
                ", college='" + college + '\'';
    }
}
