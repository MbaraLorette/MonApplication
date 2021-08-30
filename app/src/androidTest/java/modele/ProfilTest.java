package modele;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {

    //création profil
    private  Profil profil= new Profil(67,147,35,0);
    //résultat img
    private float IMG=(float)32.2;
    //message
    private String Message = "trop élevé";

    public void testGetIMG() {
        assertEquals(IMG, profil.getIMG(), (float) 0.1);

    }

    public void testGetMessage() {
        assertEquals(Message,profil.getMessage());
    }
}