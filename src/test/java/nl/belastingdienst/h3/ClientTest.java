package nl.belastingdienst.h3;


import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ClientTest {

    @Test
    public void whatsTheName() {
        Client c1 = new Client("Jan");
        Client c2 = new Client("Piet");

        c2 = c1; // c2 points to same object space as c1, in effect c2 IS c1!

        c2.setName("Joris"); // So changing c2 is the same as changing c1

        // c1 name should be Joris
        System.out.printf("Client 1 name is %s", c1.getName());

        assertTrue(c1.getName == "Joris");
    }
}
