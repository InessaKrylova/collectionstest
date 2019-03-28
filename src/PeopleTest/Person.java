package PeopleTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Person implements Comparable<Person>{
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
    public String toString(){
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
    public int hashCode() {
        final int temp = 12;
        int result = 1;
        result = temp * result + birthday.hashCode() + name.hashCode();
        if (result < 0) result = -result;
        return result;
    }

    @Override
    public int compareTo(Person o) {
        int compareResult = (this.getBirthday()).compareTo(o.getBirthday());
        return compareResult;/*(compareResult!=0)
                ? compareResult
                : (this.name).compareTo(o.name);*/
    }
}