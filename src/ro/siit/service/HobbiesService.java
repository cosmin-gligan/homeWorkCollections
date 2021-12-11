package ro.siit.service;

import ro.siit.collections.model.Address;
import ro.siit.collections.model.CollegeEnum;
import ro.siit.collections.model.Student;

import java.util.Map;
import java.util.TreeMap;

public class HobbiesService {
    public static void startApp() {
        Student student1 = new Student("Popescu", "Andrei", "1861114137926", 35, "53126", CollegeEnum.POLITENICA.toString());
        System.out.println(student1);

        Map<String, Address> addresses = new TreeMap<>(populateAddresses());

        System.out.println(addresses);
    }

    private static Map<String, Address> populateAddresses() {
        Address stefan = new Address("Stefan cel Mare", "129", "Satu-Mare", "Satu-Mare", "10532");
        Address mihai = new Address("Mihai Viteazau", "231", "Cluj-Napoca", "Cluj", "38250");
        Address vladimirescu = new Address("Tudor Vladimirescu", "572", "Bucuresti", "Bucuresti", "10182");
        Address cuza = new Address("Alexandru Cuza", "115", "Iasi", "Iasi", "44532");
        Address eminescu = new Address("Mihai Eminescu", "347", "Timisoara", "Timis", "55753");

        Map<String, Address> addressesMap = new TreeMap<>() {{
            put(stefan.getPostalCode(), stefan);
            put(mihai.getPostalCode(), mihai);
            put(mihai.getPostalCode(), mihai);
            put(cuza.getPostalCode(), vladimirescu);
            put(eminescu.getPostalCode(), vladimirescu);
        }};

        return addressesMap;

    }
}
