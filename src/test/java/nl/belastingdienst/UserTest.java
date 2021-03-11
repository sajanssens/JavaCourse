package nl.belastingdienst;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserTest {


    @Test
    public void whenUserSetsCityThenCityIsRead(){

        User u = new User();
        u.setCity("Zwolle");
        assertTrue(u.getCity() == "Zwolle");
    }

    @Test
    public void whenUserSetsAgeThenAgeIsRead(){
        User u = new User();
        u.setAge(101);
        assertTrue(u.getAge() == 101);
    }

}
