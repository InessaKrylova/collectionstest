package PeopleTest;

import java.util.Date;
import java.util.Random;

public class PeopleGenerator {
    private static final long START_1980_01_01 = 318241014062L;
    private static final long END_2010_12_31 = 1296461814062L;
    private static Random random = new Random(new Date().getTime());

    public Person nextPerson() {
        long dateLongValue = START_1980_01_01 + ((long)(random.nextDouble() * (END_2010_12_31 - START_1980_01_01)));
        int nameIndex = random.nextInt(Names.values().length);
        return new Person(
                Names.values()[nameIndex].toString(),
                new Date(dateLongValue)
        );
    }
}