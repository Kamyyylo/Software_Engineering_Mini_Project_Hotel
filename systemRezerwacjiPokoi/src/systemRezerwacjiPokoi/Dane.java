
package systemRezerwacjiPokoi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import systemRezerwacjiPokoi.model.Klient;
import systemRezerwacjiPokoi.model.Pokoj;
import systemRezerwacjiPokoi.model.Rezerwacja;
import systemRezerwacjiPokoi.model.SpecjalneZyczenie;
import systemRezerwacjiPokoi.model.Zadatek;
import java.util.Date;


public class Dane {
 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    
    public String daneKlientow[][] = new String[][]{
      
        {"Michał", "Kowalski", "98121324938", "728383241"},{"Stefan", "Nowak", "98111353113", "728308967"},
        {"Aleksandra", "Brzozowska", "82031224921", "777541821"},{"Bogdan", "Łęcki", "98051324938", "802123932"},
        {"Tomasz", "Adamski", "98011324938", "73438399"},{"Jakub", "Kania", "98061324938", "728383800"},
        {"Eleonora", "Więcławska", "97102343945", "728386094"},{"Jan", "Pasek", "72030527272", "788383112"},
        {"Genowefa", "Ozór", "53102343945", "742385494"}
     
    };
    
    public String cenyPokoi[] = {"50", "75", "100", "125", "150", "175", "200", "250"};
  
    public String danePokoi[][] = new String[][]{
        {"1", "1", "zwykly", cenyPokoi[0]},{"2", "1", "premium", cenyPokoi[1]},
        {"3", "2", "sredni", cenyPokoi[2]},{"4", "2", "premium", cenyPokoi[3]},
        {"5", "3", "zwykly", cenyPokoi[4]},{"6", "3", "sredni", cenyPokoi[5]},
        {"7", "4", "sredni", cenyPokoi[6]},{"8", "4", "premium", cenyPokoi[7]}  
    };
    
    
    public String terminy[] = {"2019-01-02","2019-01-03","2019-01-05","2019-01-06","2019-01-07","2019-02-02","2019-02-04","2019-02-05"};
    
    public int wartosciZadatkow[] = {20, 35, 50, 75, 100, 125, 175, 200};
  
    public String datyZadatkow[] = {"2019-01-01","2019-01-02","2019-01-03","2019-01-04","2019-01-05","2019-02-01","2019-02-02","2019-02-03"};
    
    public Zadatek zadatki[];
    
    public String zyczenia[][] = {{},{"basen"},{"masaz"},{"tenis"},{"masaz", "tenis"},{"basen", "tenis"},{"basen", "masaz"},{"basen", "masaz", "tenis"}};
    
    public SpecjalneZyczenie specjalneZyczenia[] = { new SpecjalneZyczenie(zyczenia[0]),new SpecjalneZyczenie(zyczenia[1]),
    new SpecjalneZyczenie(zyczenia[2]),new SpecjalneZyczenie(zyczenia[3]),new SpecjalneZyczenie(zyczenia[4]),
    new SpecjalneZyczenie(zyczenia[5]),new SpecjalneZyczenie(zyczenia[6]),new SpecjalneZyczenie(zyczenia[7])
    };
    
    public Klient klienci[] = {
        new Klient(daneKlientow[0]),new Klient(daneKlientow[1]),
        new Klient(daneKlientow[2]),new Klient(daneKlientow[3]),
        new Klient(daneKlientow[4]),new Klient(daneKlientow[5]),
        new Klient(daneKlientow[6]),new Klient(daneKlientow[7]),
        new Klient(daneKlientow[8])
    };
    
    public Pokoj pokoje[] = {
        new Pokoj(danePokoi[0]), new Pokoj(danePokoi[1]),
        new Pokoj(danePokoi[2]), new Pokoj(danePokoi[3]),
        new Pokoj(danePokoi[4]), new Pokoj(danePokoi[5]),
        new Pokoj(danePokoi[6]), new Pokoj(danePokoi[7])
    };
    
    public Rezerwacja rezerwacje[];

    public Dane() throws ParseException {

        this.zadatki = new Zadatek[]{new Zadatek(wartosciZadatkow[0],datyZadatkow[0]), new Zadatek(wartosciZadatkow[1],datyZadatkow[1]),
            new Zadatek(wartosciZadatkow[2],datyZadatkow[2]), new Zadatek(wartosciZadatkow[3],datyZadatkow[3]),
            new Zadatek(wartosciZadatkow[4],datyZadatkow[4]), new Zadatek(wartosciZadatkow[5],datyZadatkow[5]),
            new Zadatek(wartosciZadatkow[6],datyZadatkow[6]), new Zadatek(wartosciZadatkow[7],datyZadatkow[7])
        };
        
        this.rezerwacje = new Rezerwacja[]{new Rezerwacja(1, sdf.parse(terminy[0]), zadatki[0], pokoje[0], klienci[0], specjalneZyczenia[0]),
        new Rezerwacja(2, sdf.parse(terminy[1]), zadatki[1], pokoje[1], klienci[1], specjalneZyczenia[1]),
        new Rezerwacja(3, sdf.parse(terminy[2]), zadatki[2], pokoje[2], klienci[2], specjalneZyczenia[2]),
        new Rezerwacja(4, sdf.parse(terminy[3]), zadatki[3], pokoje[3], klienci[3], specjalneZyczenia[3]),
        new Rezerwacja(5, sdf.parse(terminy[4]), zadatki[4], pokoje[4], klienci[4], specjalneZyczenia[4]),
        new Rezerwacja(6, sdf.parse(terminy[5]), zadatki[5], pokoje[5], klienci[5], specjalneZyczenia[5]),
        new Rezerwacja(7, sdf.parse(terminy[6]), zadatki[6], pokoje[6], klienci[6], specjalneZyczenia[6]),
        new Rezerwacja(8, sdf.parse(terminy[7]), zadatki[7], pokoje[7], klienci[7], specjalneZyczenia[7])

        };
    }

    
}
