
package systemRezerwacjiPokoi.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import systemRezerwacjiPokoi.Aplikacja;
import systemRezerwacjiPokoi.Dane;
import systemRezerwacjiPokoi.TestEntity;

@Category({ TestEntity.class})
public class PokojTest {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    static Dane dane;
    static Aplikacja instance;
    static Pokoj pokoj; 
    @BeforeClass
    public static void setUp() throws ParseException {
       instance = new Aplikacja();
       dane = new Dane();
       pokoj = new Pokoj();
    }

    /**
     * Test of zarezerwuj method, of class Pokoj.
     */
    @Test
    public void testZarezerwuj() throws ParseException {
        System.out.println("zarezerwuj");
        for(int i=0; i < 8; i++){
        boolean rezultat = pokoj.zarezerwuj(dane.klienci[i], i, sdf.parse(dane.terminy[i]), dane.zadatki[i], dane.specjalneZyczenia[i]);
        assertTrue(rezultat); // test rezerwowania pokoju
        }
    }



    
}
