
package systemRezerwacjiPokoi.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import systemRezerwacjiPokoi.TestEntity;
import java.util.Arrays;
import java.util.Collection;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import systemRezerwacjiPokoi.Aplikacja;
import systemRezerwacjiPokoi.Dane;

@Category({ TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class KlientTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static Dane dane;
    static Aplikacja instance;
    static Klient klient;
    @Parameterized.Parameter
    public int numer1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    Object[][] data1 = new Object[][]{ {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7} };
    return Arrays.asList(data1);
    }

    @BeforeClass 
    public static void setUp() throws ParseException {
        dane= new Dane();
        instance = new Aplikacja();
        klient = new Klient();
    }



    /**
     * Test of modyfikuj method, of class Klient.
     */
    @Test
    public void test2Modyfikuj() throws ParseException {
        System.out.println("modyfikuj");
        klient.dodajRezerwacje(dane.rezerwacje[numer1]);
        boolean rezultat = klient.modyfikuj(numer1+1, sdf.parse(dane.terminy[numer1]), dane.specjalneZyczenia[numer1], dane.zadatki[numer1]);
        assertTrue(rezultat); // rezultat modyfikacji rezerwacji klienta
    }

    /**
     * Test of equals method, of class Klient.
     */
    @Test
    public void test1Equals() {
        System.out.println("equals");
        for(int j=numer1;j<7;j++)
        if(numer1==j)
        assertTrue(dane.klienci[numer1].equals(dane.klienci[j])); // test porównania
        else                                                        // równych klientów
        assertFalse(dane.klienci[numer1].equals(dane.klienci[j])); // test porównania
                                                                  // równych klientów
    }

    
}
