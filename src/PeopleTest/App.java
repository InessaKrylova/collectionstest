package PeopleTest;

import java.util.*;

public class App {
    private static Random random = new Random();

    public static void main(String[] args) {
        PeopleGenerator peopleGenerator = new PeopleGenerator();

        //1. use PeopleGenerator to fill an ArrayList
        List<Person> personsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            personsList.add(peopleGenerator.nextPerson());
        }

        //use this list to create HashSet and then TreeSet
        //check whether there were doubled values (if list.length > set.length means that list contains identical values)
        HashSet<Person> personsHashSet = new HashSet<>();
        TreeSet<Person> personsTreeSet = new TreeSet<>();

        printList("SortPersonsByAgeAndName", sortPersonsByAgeAndName(personsList));
        printList("SortPersonsByBirthday", sortPersonsByBirthday(personsList));
        printList("SortPersonsByName", sortPersonsByName(personsList));
        printList("SortPersonsByNameAndBirthday", sortPersonsByNameAndBirthday(personsList));
    }

    public static List<Person> sortPersonsByAgeAndName(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Integer age1 = ((Person) o1).getAge();
                Integer age2 = ((Person) o2).getAge();
                int compareResult = age1.compareTo(age2);

                if (compareResult!=0) {
                    return compareResult;
                } else {
                    String name1 = ((Person) o1).getName();
                    String name2 = ((Person) o2).getName();
                    return name1.compareTo(name2);
                }
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByBirthday(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Date birthDate1 = ((Person) o1).getBirthday();
                Date birthDate2 = ((Person) o2).getBirthday();
                return birthDate1.compareTo(birthDate2);
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByName(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                String name1 = ((Person) o1).getName();
                String name2 = ((Person) o2).getName();
                return name1.compareTo(name2);
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByNameAndBirthday(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                String name1 = ((Person) o1).getName();
                String name2 = ((Person) o2).getName();
                int compareResult = name1.compareTo(name2);

                if (compareResult!=0) {
                    return compareResult;
                } else {
                    Date birthDate1 = ((Person) o1).getBirthday();
                    Date birthDate2 = ((Person) o2).getBirthday();
                    return birthDate1.compareTo(birthDate2);
                }
            }}
        );
        return list;
    }

    public static void printList(String description, List<Person> list) {
        System.out.println(description+":");
        for (Person person : list) {
            System.out.println("\t"+person.toString());
        }
        System.out.println();
    }
}
/* add needed methods to store Person in HashSet and TreeSet*/

/*
3.1. using list create a Map where Map.key = list.value    Map.value = list.value.index, print it out
3.2. using map filter by name (for example name started by A to L), print it out
3.3. create treemap where Map.key = person.birthday , Map.value = person, add Comparator to compare by birthday
*/