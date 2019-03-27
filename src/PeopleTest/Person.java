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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null)
                ? 0
                : name.hashCode());
        result = prime * result + birthday.hashCode();
        result = prime * result + ((name == null)
                ? 0
                : name.hashCode());
        return result;
    }
}