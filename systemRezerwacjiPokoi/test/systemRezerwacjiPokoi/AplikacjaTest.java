
package systemRezerwacjiPokoi;

import java.text.ParseException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import systemRezerwacjiPokoi.model.Klient;
import systemRezerwacjiPokoi.model.Pokoj;
import systemRezerwacjiPokoi.model.SpecjalneZyczenie;
import systemRezerwacjiPokoi.model.Zadatek;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import systemRezerwacjiPokoi.model.Rezerwacja;

@Category(TestControl.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AplikacjaTest {

    static Dane dane;
    static Aplikacja instance;
    
    @BeforeClass 
    public static void setUp() throws ParseException {
        dane= new Dane();
        instance = new Aplikacja();
    }
    

    /**
     * Test of dodajRezerwacje method, of class Aplikacja.
     */
    @Test
    public void test4DodajRezerwacje() throws Exception {
        System.out.println("dodajRezerwacje");
        for (int i = 0; i < 8; i++) {
        boolean result = instance.dodajRezerwacje(dane.daneKlientow[i],dane.danePokoi[i], dane.terminy[i], dane.zadatki[i], dane.specjalneZyczenia[i]);
        assertTrue(result); //test poprawności dodawania rezerwacji
        }
        boolean result = instance.dodajRezerwacje(dane.daneKlientow[0],dane.danePokoi[0], dane.terminy[0], dane.zadatki[0], dane.specjalneZyczenia[0]);
        assertFalse(result); //test poprawności dodawania rezerwacji w zajętym terminie
    }

    /**
     * Test of modyfikujRezerwacje method, of class Aplikacja.
     */
    @Test
    @Category(TestModyfikacja.class)
    public void test5ModyfikujRezerwacje() throws Exception {
        System.out.println("modyfikujRezerwacje");;
        for (int i = 0; i < 4; i++) {
        boolean result = instance.modyfikujRezerwacje(dane.daneKlientow[i], i, dane.terminy[i+1], dane.zadatki[i], dane.specjalneZyczenia[i]);
        assertTrue(result); //test poprawności dodawania rezerwacji
        }
        for (int i = 4; i < 8; i++) {
        boolean result = instance.modyfikujRezerwacje(dane.daneKlientow[i], i, dane.terminy[i], dane.zadatki[i], dane.specjalneZyczenia[i]);
        assertFalse(result); //test poprawności dodawania rezerwacji
        }

    }

    /**
     * Test of dodajPokoj method, of class Aplikacja.
     */
    @Test
    public void test1DodajPokoj() {
        System.out.println("dodajPokoj");
        for (int i = 0; i < 8; i++) {
        Pokoj result = instance.dodajPokoj(dane.danePokoi[i]);
        assertEquals(dane.pokoje[i], result); //test poprawności dodawanych pokoi
        }
        
        Pokoj result = instance.dodajPokoj(dane.danePokoi[0]);
        assertNull(result); // test dodawania pokoju już istniejącego
    }

    /**
     * Test of dodajKlienta method, of class Aplikacja.
     */
    @Test
    public void test2DodajKlienta() {
        System.out.println("dodajKlienta");
        for (int i = 0; i < 8; i++) {
        Klient result = instance.dodajKlienta(dane.daneKlientow[i]);
        assertEquals(dane.klienci[i], result); // test poprawności dodawanych klientów
        }
        
        Klient result = instance.dodajKlienta(dane.daneKlientow[0]);
        assertNull(result); // test dodawania klienta już istniejącego
    }

    /**
     * Test of szukajKlienta method, of class Aplikacja.
     */
    @Test
    public void test3SzukajKlienta() {
        System.out.println("szukajKlienta");
        for (int i = 0; i < 8; i++) {
        Klient result = instance.szukajKlienta(dane.klienci[i]);
        assertEquals(dane.klienci[i], result); // test poprawności szukania klientów klientów
        }
        Klient result = instance.szukajKlienta(dane.klienci[8]);
        assertNull(result); // test szukania nieistniejącego klienta
    }

    
}
