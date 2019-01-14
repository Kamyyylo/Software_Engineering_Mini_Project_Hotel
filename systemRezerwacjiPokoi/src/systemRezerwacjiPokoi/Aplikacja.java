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
    public List getSpecjalneZyczenie() {
        // TODO - implement Aplikacja.getSpecjalneZyczenie
        throw new UnsupportedOperationException();
    }
    /**
     *
     * @param val
     */
    public void setSpecjalneZyczenie(List<SpecjalneZyczenie> val) {
        // TODO - implement Aplikacja.setSpecjalneZyczenie
        throw new UnsupportedOperationException();
    }
    /**
     *
     * @param daneKlienta
     * @param danePokoju
     * @param termin
     * @param zadatek
     * @param specjalneZyczenie
     * @return 
     */
    public boolean dodajRezerwacje(String[] daneKlienta, String[] danePokoju,Date termin, Zadatek zadatek, SpecjalneZyczenie specjalneZyczenie) {
        //podac konstruktorowi tablice lancuchow 
        Klient wKlient = new Klient(daneKlienta[0],daneKlienta[1],daneKlienta[2],Integer.parseInt(daneKlienta[3])),eKlient;
        eKlient=szukajKlienta(wKlient);     //wyszukany klient
        if(eKlient!= null)
        {
            Pokoj wPokoj = new Pokoj(Integer.parseInt(danePokoju[1]),danePokoju[2]),ePokoj;
            ePokoj = szukajPokoju(wPokoj);          //wyszukany pokoj
        if(ePokoj != null)
        {
            boolean czyZarezerwowano;
           czyZarezerwowano =  ePokoj.zarezerwuj(eKlient,nrRezerwacji++, termin, zadatek, specjalneZyczenie);  //jesli true to zarezerwowany, jesli false to brak terminu   
           System.out.println("pokoje: "+ pokoje);
            System.out.println("klienci: "+ klienci);
           return czyZarezerwowano;
        }//System.out.println("Brak rezerwacji");
        
        System.out.println("brak wyszukanego pokoju");
        return false;  //brak wyszukanego pokoju zwraca false
        
        }
        System.out.println("brak klienta");
        return false;   //brak klienta 
    }
    public boolean modyfikujRezerwacje(String[] daneKlienta,int nrRezerwacji, Date termin, Zadatek zadatek, SpecjalneZyczenie zyczenie){
        Klient wKlient = new Klient(daneKlienta[0],daneKlienta[1],daneKlienta[2],Integer.parseInt(daneKlienta[3])), eKlient; 
        eKlient=szukajKlienta(wKlient);     //wyszukany klient
         if(eKlient!= null)
        {
            if( eKlient.modyfikuj(nrRezerwacji, termin, zyczenie, zadatek ))
            {         

            System.out.println("Udalo sie zmodyfikować");
            return true;
            }
            else{
            return false;
            }        
        }
         System.out.println("brak klienta");
        return false;
    }

  
    public Pokoj dodajPokoj(int nrPokoju, int wielkoscPokoju, String standardPokoju, int cenaPokoju)
    {
        Pokoj nowyPokoj = new Pokoj(nrPokoju, wielkoscPokoju, standardPokoju, cenaPokoju);
        if(this.szukajPokoju(nowyPokoj)==null)
        {
            pokoje.add(nowyPokoj);
        }
        return nowyPokoj;
    }
    //tutaj tez podawac tablice lancuchow
    public Klient dodajKlienta(String imie, String nazwisko, String pesel, int nrTelefonu) {

        Klient nowyKlient = new Klient(imie, nazwisko, pesel, nrTelefonu);
        if (this.szukajKlienta(nowyKlient)== null) {
            klienci.add(nowyKlient);
        }
        return nowyKlient;
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
        String listaKlientow;
        String listaPokoji;
        Aplikacja app = new Aplikacja();

        String[] daneklienta1 = {"Artur", "Borewicz", "98131324938", "123456789"};
        String[] daneklienta2 = {"Tomek", "Kowalski", "97102409554", "123456789"};
        String[] danepokoju1 = {"1", "2", "zwykly", "100"};              //dane pokoju testowego
        String[] danepokoju2 = {"2", "2", "niezwykly", "100"};   
        
        Zadatek zadatek1 = new Zadatek();
        int zadatekTmp = 50;
        zadatek1.setZadatek(zadatekTmp);
        
         Zadatek zadatek2 = new Zadatek();
        int zadatekTmp2 = 100;
        zadatek2.setZadatek(zadatekTmp2);
        
        Date termin2 = sdf.parse("2018-12-05");
        Date termin3 = sdf.parse("2018-12-09");
        
        String zyczenie1[] = {"basen", "masaz"};
        SpecjalneZyczenie zyczenieTest = new SpecjalneZyczenie();
        zyczenieTest.setZyczenie(zyczenie1);
        
        String zyczenie2[] = {"golf", "chleb"};
        SpecjalneZyczenie zyczenieTest2 = new SpecjalneZyczenie();
        zyczenieTest2.setZyczenie(zyczenie2);
        
        
        app.dodajKlienta("Artur", "Borewicz", "98131324938", 123456789);
        app.dodajKlienta("Tomek", "Kowalski", "97102409554", 123456789);
        app.dodajPokoj(1, 2, "zwykly", 100);
        app.dodajPokoj(2, 3, "niezwykly", 200);

        listaKlientow = app.getKlient().toString();
        listaPokoji = app.getPokoj().toString();
        System.out.println(listaKlientow);
        System.out.println(listaPokoji);
        

        app.dodajRezerwacje(daneklienta2, danepokoju1,termin2, zadatek1, zyczenieTest);
        app.dodajRezerwacje(daneklienta2, danepokoju1,termin2, zadatek1, zyczenieTest);
        app.dodajRezerwacje(daneklienta1, danepokoju1,termin3, zadatek1, zyczenieTest);
        System.out.println("klienci po dodaniu: "+app.klienci);
        System.out.println("pokoje po dodaniu:" + app.pokoje);
        app.modyfikujRezerwacje(daneklienta2, 0, termin3, zadatek2, zyczenieTest2);
        System.out.println("\nKlient po modyfikacji"+ app.klienci);

    }
}
