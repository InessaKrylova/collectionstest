package PeopleTest;

import java.text.SimpleDateFormat;
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

    public int getAge() {
        int age=0;
        age = (new Date()).getYear() - birthday.getYear();
        //TODO sort by month and day
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
}