package PeopleTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Person {
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

    public Integer getAge() {
        Date today = new Date();
        int curYear = today.getYear();
        int birthYear = birthday.getYear();

        int age = curYear - birthYear;
        int curMonth = today.getMonth();
        int birthMonth = birthday.getMonth();

        if (birthMonth > curMonth) {
            age--;
        } else if (birthMonth == curMonth) {
            int curDay = today.getDate();
            int dobDay = birthday.getDate();
            if (dobDay > curDay) { // this year can't be counted!
                age--;
            }
        }
        return age;
    }

    //proper method to print out a Person
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(name)
          .append("; ")
          .append(getAge())
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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person unknown = (Person) obj;
        return  (birthday == unknown.getBirthday())
                &&
                (
                    (name == unknown.name)
                    ||
                    (name != null &&name.equals(unknown.getName()))
                );
    }

    @Override
    public int hashCode(){
        final int temp = 12;
        int result = 1;
        result = temp * result + ((name == null)
                ? 0
                : name.hashCode());
        result = temp * result + birthday.hashCode();
        result = temp * result + ((name == null)
                ? 0
                : name.hashCode());
        if (result<0) result = -result;
        return result;
    }

    public int compareByName(Person other) {
        return this.getName().compareTo(other.getName());
    }
}