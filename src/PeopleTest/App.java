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

        printList("SortPersonsByAgeAndName", sortPersonsByAgeAndName(personsList));
        //printList("SortPersonsByBirthday", sortPersonsByBirthday(personsList));
        //printList("SortPersonsByName", sortPersonsByName(personsList));
        //printList("SortPersonsByNameAndBirthday", sortPersonsByNameAndBirthday(personsList));

        //use this list to create HashSet and then TreeSet
        //check whether there were doubled values (if list.length > set.length means that list contains identical values)
        HashSet<Person> personsHashSet = new HashSet<>();
        TreeSet<Person> personsTreeSet = new TreeSet<>();
    }

    public static List<Person> sortPersonsByAgeAndName(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                int compareResult = p1.getAge().compareTo(p2.getAge());

                return (compareResult!=0)
                        ? compareResult
                        : p1.getName().compareTo(p2.getName());
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByBirthday(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                return p1.getBirthday().compareTo(p2.getBirthday());
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByName(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                return p1.getName().compareTo(p2.getName());
            }}
        );
        return list;
    }

    public static List<Person> sortPersonsByNameAndBirthday(List<Person> list) {
        Collections.sort(list, new Comparator() {
            // one person is greater then another if he is older that other, if two persons has the same age compare by names
            public int compare(Object o1, Object o2) {
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                int compareResult = p1.getName().compareTo(p2.getName());

                return (compareResult!=0)
                        ? compareResult
                        : p1.getBirthday().compareTo(p2.getBirthday());
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

    public void addPersonToHashSet(HashSet<Person> hashSet, Person person){

    }

    public void addPersonToTreeSet(TreeSet<Person> treeSet, Person person){

    }
}

/* add needed methods to store Person in HashSet and TreeSet*/

/*
3.1. using list create a Map where Map.key = list.value    Map.value = list.value.index, print it out
3.2. using map filter by name (for example name started by A to L), print it out
3.3. create treemap where Map.key = person.birthday , Map.value = person, add Comparator to compare by birthday
*/