package systemRezerwacjiPokoi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import systemRezerwacjiPokoi.model.Klient;
import systemRezerwacjiPokoi.model.Pokoj;
import systemRezerwacjiPokoi.model.SpecjalneZyczenie;
import systemRezerwacjiPokoi.model.Zadatek;

public class Aplikacja {

    int nrRezerwacji = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final List<Klient> klienci = new ArrayList<>();
    private final List<Pokoj> pokoje = new ArrayList<>();
    public Aplikacja() {

    }
    public List<Klient> getKlient() {
        return klienci;
    }
    public List<Pokoj> getPokoj()
    {
        return pokoje;
    }
  
    /**
     *
     * @param daneKlienta
     * @param danePokoju
     * @param termin
     * @param zadatek
     * @param specjalneZyczenie
     * @return 
     * @throws java.text.ParseException 
     */
    public boolean dodajRezerwacje(String[] daneKlienta, String[] danePokoju, String termin, Zadatek zadatek, SpecjalneZyczenie specjalneZyczenie) throws ParseException {
         
        Klient wKlient = new Klient(daneKlienta),eKlient;

        eKlient=szukajKlienta(wKlient);     //wyszukany klient
        if(eKlient!= null)
        {
            Pokoj wPokoj = new Pokoj(danePokoju),ePokoj;

            ePokoj = szukajPokoju(wPokoj);          //wyszukany pokoj
        if(ePokoj != null)
        {
            boolean czyZarezerwowano;

           czyZarezerwowano =  ePokoj.zarezerwuj(eKlient,nrRezerwacji++, sdf.parse(termin), zadatek, specjalneZyczenie);  //jesli true to zarezerwowany, jesli false to brak terminu   

//           System.out.println("pokoje: "+ pokoje);
//            System.out.println("klienci: "+ klienci);
           return czyZarezerwowano;
        }
        
//        System.out.println("brak wyszukanego pokoju");
        return false;  //brak wyszukanego pokoju zwraca false
        
        }
//        System.out.println("brak klienta");
        return false;   //brak klienta 
    }
    public boolean modyfikujRezerwacje(String[] daneKlienta,int nrRezerwacji, String termin, Zadatek zadatek, SpecjalneZyczenie zyczenie) throws ParseException{
        Klient wKlient = new Klient(daneKlienta), eKlient;

        eKlient=szukajKlienta(wKlient);     //wyszukany klient
         if(eKlient!= null)
        {
            
            if( eKlient.modyfikuj(nrRezerwacji, sdf.parse(termin), zyczenie, zadatek ))
            {         
//            System.out.println("Udalo sie zmodyfikować");
            return true;
            }
            else{
            return false;
            }        
        }
//         System.out.println("Brak klienta");
        return false;
    }

  
    public Pokoj dodajPokoj(String[] danePokoju)
    {
        Pokoj wPokoj = new Pokoj(danePokoju);
        if(this.szukajPokoju(wPokoj)==null)
        {
            pokoje.add(wPokoj);
            return wPokoj;
        }
        return null;
    }
    
    public Klient dodajKlienta(String[] daneKlienta) {

        Klient nowyKlient = new Klient(daneKlienta);
        if (this.szukajKlienta(nowyKlient)== null) {
            klienci.add(nowyKlient);
            return nowyKlient;
        }
        return null;
    }

    /**
     *
     * @param tmp
     * @return
     */
    public Klient szukajKlienta(Klient tmp) {
        int idx = this.klienci.indexOf(tmp);
        if (idx != -1) {
           return this.klienci.get(idx);
        }
        return null;
    }
    /**
     *
     * @param wPokoj
     * @return
     */
    public Pokoj szukajPokoju(Pokoj wPokoj) {
        int idx = this.pokoje.indexOf(wPokoj);
        if(idx!=-1)
        {
            return this.pokoje.get(idx);
        } 
           return null;
    }

    /**
     *
     * @param args
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Dane dane = new Dane();
        String listaKlientow;
        String listaPokoji;
        Aplikacja app = new Aplikacja();

        
        Zadatek zadatek1 = new Zadatek();
        int zadatekTmp = 50;
        zadatek1.setZadatek(zadatekTmp);
        
         Zadatek zadatek2 = new Zadatek();
        int zadatekTmp2 = 100;
        zadatek2.setZadatek(zadatekTmp2);
        
        app.dodajKlienta(dane.daneKlientow[0]);
        app.dodajKlienta(dane.daneKlientow[1]);
        app.dodajPokoj(dane.danePokoi[0]);
        app.dodajPokoj(dane.danePokoi[1]);

        listaKlientow = app.getKlient().toString();
        listaPokoji = app.getPokoj().toString();
        System.out.println(listaKlientow);
        System.out.println(listaPokoji);
        

        app.dodajRezerwacje(dane.daneKlientow[0], dane.danePokoi[0],dane.terminy[0], dane.zadatki[0], dane.specjalneZyczenia[1]);
        app.dodajRezerwacje(dane.daneKlientow[1], dane.danePokoi[0],dane.terminy[1], dane.zadatki[1], dane.specjalneZyczenia[2]);
        app.dodajRezerwacje(dane.daneKlientow[0], dane.danePokoi[0],dane.terminy[2], dane.zadatki[2], dane.specjalneZyczenia[3]);
        System.out.println("klienci po dodaniu: "+app.klienci);
        System.out.println("pokoje po dodaniu:" + app.pokoje);
        app.modyfikujRezerwacje(dane.daneKlientow[0], 0, dane.terminy[3], dane.zadatki[2], dane.specjalneZyczenia[3]);
        System.out.println("\nKlient po modyfikacji"+ app.klienci);

    }
}
