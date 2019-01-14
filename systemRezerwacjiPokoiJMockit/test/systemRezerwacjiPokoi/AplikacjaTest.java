
package systemRezerwacjiPokoi;

import java.util.Arrays;
import mockit.Expectations;
import mockit.FullVerificationsInOrder;
import mockit.Injectable;
import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.Tested;
import mockit.VerificationsInOrder;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import systemRezerwacjiPokoi.model.Klient;
import systemRezerwacjiPokoi.model.Rezerwacja;


@RunWith(JMockit.class)
public class AplikacjaTest {

    @Injectable
    Klient klient1, klient2, klient3;
    
    @Test
    public void testSzukajKlienta() {
        System.out.println("szukajKlienta");
        Klient klienci[] = {klient1, klient2, klient3};
        Aplikacja aplikacja = new Aplikacja();
        aplikacja.setKlient(Arrays.asList(klienci));
        for (int i = 0; i < 3; i++) {
            assertEquals(aplikacja.szukajKlienta(klienci[i]), klienci[i]); //dodatkowy test assertEquals   
        }
        
        new FullVerificationsInOrder() {
            {
            klient1.equals(any); times = 2;
            klient2.equals(any); times = 3;
            klient3.equals(any); times = 4;
            }
        };
    }
     
    

    
        

    
}
