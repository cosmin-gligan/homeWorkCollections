package ro.siit.service;


import ro.siit.collections.model.Address;
import ro.siit.collections.model.CollegeEnum;
import ro.siit.collections.model.Hobby;
import ro.siit.collections.model.Student;

import java.util.*;

public class HobbiesService {

    public static void startApp() {

        Map<String, Student> students = new TreeMap<>(populateStudents());
        Map<String, Address> addresses = new TreeMap<>(populateAddresses());
        Map<String, Hobby> hobbies = new HashMap<>(populateHobbies(addresses));

        Map<Student, ArrayList<Hobby>> studentHobbies = new HashMap<>(populateStudentsHobbies(students, hobbies));

        Student randomStudent = getRandomStudent(students);

//        System.out.println(randomStudent);

        printStudentHobbies(randomStudent, studentHobbies);
    }

    private static Map<String, Student> populateStudents() {
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
            put(nicoaraTania.getCnp(), nicoaraTania );
            put(panaClaudia.getCnp(), panaClaudia );
        }};
        return studentsMap;
    }

    private static Map<String, Address> populateAddresses() {
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

        Map<String, Address> addressesMap = new TreeMap<>() {{
            put(stefan.getPostalCode(), stefan);
            put(mihai.getPostalCode(), mihai);
            put(mihai.getPostalCode(), mihai);
            put(cuza.getPostalCode(), vladimirescu);
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

    private static Map<String, Hobby> populateHobbies(Map<String, Address> addresses) {

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

        Hobby bowling = new Hobby("Bowling", 1);
        List<Address> bowlingAddresses = new ArrayList<>();
        bowlingAddresses.add(addresses.get("82357"));
        bowlingAddresses.add(addresses.get("62151"));
        bowling.setAddressList(bowlingAddresses);

        Hobby cinema = new Hobby("Cinema", 1);
        List<Address> cinemaAddresses = new ArrayList<>();
        bowlingAddresses.add(addresses.get("62151"));
        bowlingAddresses.add(addresses.get("15710"));
        bowling.setAddressList(bowlingAddresses);

        Map<String, Hobby> hobbiesMap = new TreeMap<>() {{
            put(gym.getName(), gym);
            put(swimming.getName(), swimming);
        }};
        return hobbiesMap;
    }

    private static Map<Student, ArrayList<Hobby>> populateStudentsHobbies(Map<String, Student> studentMap, Map<String, Hobby> hobbiesMap) {
        Map<Student, ArrayList<Hobby>> studentHobbiesMap = new HashMap<>();

        for (Map.Entry<String, Student> studentEntry : studentMap.entrySet()) {
            ArrayList<Hobby> studentHobbiesList = new ArrayList<>();
            for (int i = 0; i < randomNumber(1, hobbiesMap.size()); i++) {
                studentHobbiesList.add(getRandomHobby(hobbiesMap));
            }
            studentHobbiesMap.put(studentEntry.getValue(), studentHobbiesList);
        }
        return studentHobbiesMap;
    }

    private static int randomNumber(int minNoOfHobbies, int maxNoOfHobbies){
        Random random =  new Random();
        return random.nextInt(maxNoOfHobbies - minNoOfHobbies + 1) + minNoOfHobbies;
    }

    private static Hobby getRandomHobby(Map<String, Hobby> hobbiesMap){
        Object[] hobbiesKeys = hobbiesMap.keySet().toArray();
        List<Object> shuffleList = new ArrayList<>(Arrays.asList(hobbiesKeys));
        Collections.shuffle(shuffleList);

        return hobbiesMap.get(shuffleList.get(randomNumber(0, shuffleList.size() - 1)));
    }

    private static Student getRandomStudent(Map<String, Student> studentMap){
        Object[] studentKeys = studentMap.keySet().toArray();
        List<Object> shuffleList = new ArrayList<>(Arrays.asList(studentKeys));
        Collections.shuffle(shuffleList);

        return studentMap.get(shuffleList.get(randomNumber(0, shuffleList.size() - 1)));
    }


    private static void printStudentHobbies(Student student, Map<Student, ArrayList<Hobby>> studentHobbies){
        Map.Entry<Student, ArrayList<Hobby>> studentHobies = null;

        for ( Map.Entry<Student, ArrayList<Hobby>>  mapEntry : studentHobbies.entrySet()){
            if (mapEntry.getKey() == student){
                studentHobies = mapEntry;
                break;
            }
        }

        StringBuilder st = new StringBuilder();
        st.append(student.toString());
        for ( Hobby hobby :  studentHobies.getValue()){
            st.append("\n" + hobby.toString());
        }

        System.out.println(st.toString());
    }



}
