package nl.belastingdienst.h7;

public class Person {
    private Gender gender;
    private String name;
    private int age;

    public Person(String name, int age) throws PersonDiedException {
        this.setAge(age);
        this.setName(name);
        this.setGender(Gender.UNKNOWN);
    }

    public static int numberOfPossibleGenders(){
        return Gender.values().length;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws PersonDiedException {
        if (age >= 130) {
            throw new PersonDiedException("E001", "Person is 130 years or older and died");
        }
        this.age = age;
    }

    public void haveBirthday() throws PersonDiedException {
        this.setAge(++this.age);
    }
}
