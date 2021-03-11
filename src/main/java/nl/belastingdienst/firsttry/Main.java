package nl.belastingdienst.firsttry;

public class Main {
    public static void main(String[] args){

        User u1 = new User();
        u1.setCity("Nroodlepa");
        u1.setAge(33);

        User u2 = new User();
        u2.setCity("Madretsma");
        u2.setAge(44);

        u1.introduce();
        u2.introduce();

    }
}
