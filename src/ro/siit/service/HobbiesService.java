package ro.siit.service;


import ro.siit.collections.model.Address;
import ro.siit.collections.model.CollegeEnum;
import ro.siit.collections.model.Hobby;
import ro.siit.collections.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class HobbiesService implements MinimumRequirements {

    public void startApp() {
        //populam stundetii
        Map<String, Student> students = new TreeMap<>(populateStudents());
        //populam adresele
        Map<String, Address> addresses = new TreeMap<>(populateAddresses());
        //populam hobby-urile ( setam si adresele pe hobby-uri )
        Map<String, Hobby> hobbies = new HashMap<>(populateHobbies(addresses));

        //setam hobby-uri aleatorii pe studenti
        Map<Student, List<Hobby>> studentHobbies = new HashMap<>(populateStudentsHobbies(students, hobbies));
        Student randomStudent = getRandomStudent(students);
        //afisam hobby-urile pt. un student aleator
        printStudentHobbies(randomStudent, studentHobbies);

        //facem o lista in care grupa studentii pe un hobby
        Map<Hobby, Collection<Student>> students4Hobbies = new TreeMap<>();
        for (Hobby hobby : hobbies.values()) {
            Collection<Student> students4Hobby = findStudentsWithHobby(hobby, studentHobbies);
            students4Hobbies.put(hobby, students4Hobby);
        }

        //afisam studentii pt. fiecare hobby
        printStudents4Hobbies(students4Hobbies);

        //studentii "share-uiti" intre 2 hobby-uri
        Map.Entry<Hobby, Collection<Student>> previousMapEntry = null;
        for (Map.Entry<Hobby, Collection<Student>> currentMapEntry : students4Hobbies.entrySet()) {
            //daca avem un hobby anterior ( comparam cel curent cu anteriorul )
            if (previousMapEntry != null) {
                //studentii "share-uiti"
                Collection<Student> studentWithSharedHobbies = findIntersection(previousMapEntry.getValue(), currentMapEntry.getValue());
                //afisam lista de studenti "share-uiti" pe hobby-uri
                printSharedStudentsBetweenHobies(previousMapEntry.getKey(), currentMapEntry.getKey(), studentWithSharedHobbies);
            }
            previousMapEntry = currentMapEntry;
        }

    }

    private Map<String, Student> populateStudents() {
        Student andreiPopescu = new Student("Popescu", "Andrei", "1861114137926", 35, "53126", CollegeEnum.POLITENICA.toString());
        Student ioanaGheorghe = new Student("Gheorghe", "Ioana", "2940122121224", 27, "12126", CollegeEnum.MEDICINA.toString());
        Student berindeSergiu = new Student("Berinde", "Sergiu", "1990209160134", 22, "22173", CollegeEnum.DREPT.toString());
        Student mirceaToma = new Student("Toma", "Mircea", "5020809209718", 19, "72175", CollegeEnum.STIINTE_POLITICE.toString());
        Student simonaVeres = new Student("Veres", "Simona", "2970510063140", 24, "92175", CollegeEnum.STIINTE_ECONOMICE.toString());
        Student silviuMarina = new Student("Marina", "Silviu", "2940206250695", 27, "112175", CollegeEnum.LITERE.toString());
        Student bicuStefan = new Student("Bicu", "Stefan", "1970707352806", 24, "100113", CollegeEnum.STIINTE_ECONOMICE.toString());
        Student coatuSorin = new Student("Coatu", "Sorin", "5011027216305", 20, "107180", CollegeEnum.POLITENICA.toString());
        Student dunaDenisa = new Student("Duna", "Denisa", "2930408140399", 28, "109003", CollegeEnum.DREPT.toString());
        Student nicoaraTania = new Student("Nicoara", "Tania", "6010903360261", 20, "111007", CollegeEnum.MEDICINA.toString());
        Student panaClaudia = new Student("Pana", "Claudia", "2991024342055", 22, "167005", CollegeEnum.POLITENICA.toString());

        //folosim CNP-ul ca si key pt. map
        Map<String, Student> studentsMap = new TreeMap<>() {{
            put(andreiPopescu.getCnp(), andreiPopescu);
            put(ioanaGheorghe.getCnp(), ioanaGheorghe);
            put(berindeSergiu.getCnp(), berindeSergiu);
            put(mirceaToma.getCnp(), mirceaToma);
            put(simonaVeres.getCnp(), simonaVeres);
            put(silviuMarina.getCnp(), silviuMarina);
            put(bicuStefan.getCnp(), bicuStefan);
            put(coatuSorin.getCnp(), coatuSorin);
            put(dunaDenisa.getCnp(), dunaDenisa);
            put(nicoaraTania.getCnp(), nicoaraTania);
            put(panaClaudia.getCnp(), panaClaudia);
        }};
        return studentsMap;
    }

    private Map<String, Address> populateAddresses() {
        Address stefan = new Address("Stefan cel Mare", "129", "Satu-Mare", "Satu-Mare", "10532");
        Address mihai = new Address("Mihai Viteazau", "231", "Cluj-Napoca", "Cluj", "38250");
        Address vladimirescu = new Address("Tudor Vladimirescu", "572", "Bucuresti", "Bucuresti", "10182");
        Address cuza = new Address("Alexandru Cuza", "115", "Iasi", "Iasi", "44532");
        Address eminescu = new Address("Mihai Eminescu", "347", "Timisoara", "Timis", "55753");
        Address sperantei = new Address("Sperantei", "50", "Bucuresti", "Bucuresti", "50185");
        Address viitorului = new Address("Viitorului", "21", "Brasov", "Brasov", "70185");
        Address observator = new Address("Observator", "15", "Dej", "Cluj", "82357");
        Address sadoveanu = new Address("Mihail Sadoveanu", "75", "Baia-Mare", "Maramures", "12357");
        Address rebreanu = new Address("Liviu Rebreanu", "12", "Buzau", "Buzau", "62151");
        Address enescu = new Address("George Enescu", "33", "Oradea", "Bihor", "15710");

        //folosim codul postal ( e suficient pt. tema ) ca si cheie pt. harta
        Map<String, Address> addressesMap = new TreeMap<>() {{
            put(stefan.getPostalCode(), stefan);
            put(mihai.getPostalCode(), mihai);
            put(vladimirescu.getPostalCode(), vladimirescu);
            put(cuza.getPostalCode(), cuza);
            put(eminescu.getPostalCode(), eminescu);
            put(sperantei.getPostalCode(), sperantei);
            put(viitorului.getPostalCode(), viitorului);
            put(observator.getPostalCode(), observator);
            put(sadoveanu.getPostalCode(), sadoveanu);
            put(rebreanu.getPostalCode(), rebreanu);
            put(enescu.getPostalCode(), enescu);
        }};
        return addressesMap;
    }
    //populam lista de adrese pe hobby-uri
    private Map<String, Hobby> populateHobbies(Map<String, Address> addresses) {
        Hobby gym = new Hobby("Gym", 3);
        List<Address> gymAddresses = new ArrayList<>();
        gymAddresses.add(addresses.get("10532"));
        gymAddresses.add(addresses.get("44532"));
        gymAddresses.add(addresses.get("10182"));
        gym.setAddressList(gymAddresses);

        Hobby swimming = new Hobby("Swimming", 2);
        List<Address> swimmingAddresses = new ArrayList<>();
        swimmingAddresses.add(addresses.get("50185"));
        swimmingAddresses.add(addresses.get("70185"));
        swimming.setAddressList(swimmingAddresses);

        Hobby darts = new Hobby("Darts", 1);
        List<Address> dartsAddresses = new ArrayList<>();
        dartsAddresses.add(addresses.get("82357"));
        dartsAddresses.add(addresses.get("12357"));
        darts.setAddressList(dartsAddresses);

        Hobby bowling = new Hobby("Bowling", 2);
        List<Address> bowlingAddresses = new ArrayList<>();
        bowlingAddresses.add(addresses.get("82357"));
        bowlingAddresses.add(addresses.get("62151"));
        bowling.setAddressList(bowlingAddresses);

        Hobby cinema = new Hobby("Cinema", 3);
        List<Address> cinemaAddresses = new ArrayList<>();
        cinemaAddresses.add(addresses.get("62151"));
        cinemaAddresses.add(addresses.get("15710"));
        cinema.setAddressList(cinemaAddresses);

        Hobby zoo = new Hobby("Zoo", 1);
        List<Address> zooAddresses = new ArrayList<>();
        zooAddresses.add(addresses.get("70185"));
        zooAddresses.add(addresses.get("10532"));
        zoo.setAddressList(zooAddresses);

        Hobby shopping = new Hobby("Shopping", 3);
        List<Address> shoppingAddresses = new ArrayList<>();
        shoppingAddresses.add(addresses.get("44532"));
        shoppingAddresses.add(addresses.get("62151"));
        shopping.setAddressList(shoppingAddresses);

        Map<String, Hobby> hobbiesMap = new TreeMap<>() {{
            put(gym.toString(), gym);
            put(swimming.toString(), swimming);
            put(darts.toString(), darts);
            put(bowling.toString(), bowling);
            put(cinema.toString(), cinema);
            put(zoo.toString(), zoo);
            put(shopping.toString(), shopping);
        }};
        return hobbiesMap;
    }

    //hobby-uri aleatorii pentru studenti
    private Map<Student, List<Hobby>> populateStudentsHobbies(Map<String, Student> studentMap, Map<String, Hobby> hobbiesMap) {
        Map<Student, List<Hobby>> studentHobbiesMap = new HashMap<>();
        for (Map.Entry<String, Student> studentEntry : studentMap.entrySet()) {
            List<Hobby> studentHobbiesList = new ArrayList<>();
            //numar aletoriu de hobby-uri pe student
            int randomNoOfHobbies = randomNumber(1, hobbiesMap.size());
            for (int i = 0; i < randomNoOfHobbies; i++) {
                Hobby randomHobby = getRandomHobby(hobbiesMap);
                if (!studentHobbiesList.contains(randomHobby))
                    studentHobbiesList.add(randomHobby);
            }
            //setam lista de hobby-uri pe student
            studentHobbiesMap.put(studentEntry.getValue(), studentHobbiesList);
        }
        return studentHobbiesMap;
    }

    //numar aleatoriu de hobby-uri ( folosim si in randomNoOfHobbies )
    private int randomNumber(int minNoOfHobbies, int maxNoOfHobbies) {
        Random random = new Random();
        return random.nextInt(maxNoOfHobbies - minNoOfHobbies + 1) + minNoOfHobbies;
    }
    // intoarce un hobby aleatoriu ( folosit pt. popularea listei de hobby-uri pe student )
    private Hobby getRandomHobby(Map<String, Hobby> hobbiesMap) {
        Object[] hobbiesKeys = hobbiesMap.keySet().toArray();
        List<Object> shuffleList = new ArrayList<>(Arrays.asList(hobbiesKeys));
        Collections.shuffle(shuffleList);

        return hobbiesMap.get(shuffleList.get(randomNumber(0, shuffleList.size() - 1)));
    }

    //intoarce un student aleatoriu
    private Student getRandomStudent(Map<String, Student> studentMap) {
        Object[] studentKeys = studentMap.keySet().toArray();
        List<Object> shuffleList = new ArrayList<>(Arrays.asList(studentKeys));
        Collections.shuffle(shuffleList);

        return studentMap.get(shuffleList.get(randomNumber(0, shuffleList.size() - 1)));
    }

    //implementam metoda ceruta de interfata "MinimumRequirements"
    //afisam hobby-urile aferente fiecarui student
    @Override
    public void printStudentHobbies(Student student, Map<Student, List<Hobby>> studentHobbies) {
        Map.Entry<Student, List<Hobby>> studentHobies = null;
        for (Map.Entry<Student, List<Hobby>> mapEntry : studentHobbies.entrySet()) {
            if (mapEntry.getKey() == student) {
                studentHobies = mapEntry;
                break;
            }
        }

        StringBuilder st = new StringBuilder();
        st.append(student.toString());
        st.append("\n\tHobbies list:");
        for (Hobby hobby : studentHobies.getValue()) {
            st.append("\n\t\t - " + hobby.toString() + ": " + hobby.getCitiesList());
        }
        System.out.println(st.toString());
    }

    //implementam metoda ceruta de interfata "MinimumRequirements"
    //intoarce o lista de studenti care au un hobby comun
    @Override
    public Collection<Student> findStudentsWithHobby(Hobby hobby, Map<Student, List<Hobby>> studentHobbies) {
        Collection<Student> studentsList = new TreeSet<>();
        for (Map.Entry<Student, List<Hobby>> mapEntry : studentHobbies.entrySet()) {
            List<Hobby> hobbiesList = mapEntry.getValue();
            if (hobbiesList.contains(hobby)) {
                if (!studentsList.contains(mapEntry.getKey())) {
                    studentsList.add(mapEntry.getKey());
                }
            }
        }
        return studentsList;
    }

    //afisam lista de studenti care practica un hobby
    public void printStudents4Hobbies(Map<Hobby, Collection<Student>> students4Hobbies) {
        for (Map.Entry<Hobby, Collection<Student>> mapEntry : students4Hobbies.entrySet()) {
            System.out.println("\n" + mapEntry.getKey().toString() + ": " + mapEntry.getKey().getCitiesList());
            for (Student student : mapEntry.getValue()) {
                System.out.println("\n\t - " + student);
            }
        }
    }

    //implementam metoda ceruta de interfata "MinimumRequirements"
    //lista de studenti care sunt comuni pt. 2 hobby-uri
    @Override
    public Collection<Student> findIntersection(Collection<Student> c1, Collection<Student> c2) {
        Collection intersectionList = new TreeSet();
        intersectionList = c1.stream().distinct().filter(c2::contains).collect(Collectors.toSet());
        //varianta manuala, cea de mai sus e mai eleganta
        /*
        for (Student student : c1) {
            if (c2.contains(student)){
                if (!intersectionList.contains(student)){
                    intersectionList.add(student);
                }
            }
        }
        */
        return intersectionList;
    }
    //afisam lista de studenti comuni pt. 2 hobby-uri
    public void printSharedStudentsBetweenHobies(Hobby hobby1, Hobby hobby2, Collection<Student> studentCollection) {
        System.out.println("\nUrmatorii studenti impartasesc " + hobby1.toString() + " si " + hobby2.toString() + ":");
        for (Student student : studentCollection) {
            System.out.println("\n\t" + student);
        }
    }
}