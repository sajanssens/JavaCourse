package nl.belastingdienst.h7;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson() throws PersonDiedException {
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday(); // person gets one year older
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders());

        p.setAge(130);

    }
}
