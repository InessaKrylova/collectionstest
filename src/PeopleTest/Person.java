package PeopleTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
    private String name;
    private Date birthday;

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //proper method to print out a Person
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(name)
                .append("; ")
                .append(format.format(birthday))
                .append("] ");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;

        if (getBirthday() != null && other.getBirthday() == null) {
            return false;
        }
        return true;
   //TODO

//        return (birthday.equals(OTHER.getBirthday()))
//                &&
//                (
//                        (name.equals(OTHER.name))
//                                ||
//                                (name != null && name.equals(OTHER.getName()))
//                );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (birthday != null) {
            result = prime * result + birthday.hashCode();
        }
        if (name != null) {
            result = prime * result + name.hashCode();
        }
        return result;
    }

    @Override
    public int compareTo(Person o) {
        int compareResult = (this.getBirthday()).compareTo(o.getBirthday());
        return (compareResult == 0)
                ? compareResult
                : (this.name).compareTo(o.name);
    }
}