package systemRezerwacjiPokoi.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Klient {

	private String imieKlienta;
	private String nazwiskoKlienta;
        private String pesel;
	private int nrTelefonu;
	private ArrayList<Rezerwacja> rezerwacje = new ArrayList();

    public Klient() {
        this.imieKlienta="";
        this.nazwiskoKlienta="";
        this.pesel="";
        this.nrTelefonu=0;
    }
    
    public Klient(String imie, String nazwisko, String pesel, int nrTelefonu) {
        this.imieKlienta=imie;
        this.nazwiskoKlienta=nazwisko;
        this.pesel=pesel;
        this.nrTelefonu=nrTelefonu;
    }
    
    public Klient(String[] daneKlienta) {
        this.imieKlienta=daneKlienta[0];
        this.nazwiskoKlienta=daneKlienta[1];
        this.pesel=daneKlienta[2];
        this.nrTelefonu= Integer.parseInt(daneKlienta[3]);
    }
    public Rezerwacja szukajRezerwacji(Rezerwacja tmp) {
     
        int idx = this.rezerwacje.indexOf(tmp);
        if (idx != -1) {
           return this.rezerwacje.get(idx);
        }
        return null;
    }
    
     public boolean modyfikuj(int nrRezerwacji, Date termin, SpecjalneZyczenie zyczenie, Zadatek zadatek )
     {
         Rezerwacja wRezerwacja= new Rezerwacja();
         wRezerwacja.setNrRezerwacji(nrRezerwacji);
         Rezerwacja eRezerwacja;
         eRezerwacja =  szukajRezerwacji(wRezerwacja);         
         if(eRezerwacja!= null)
         {
             
             if(eRezerwacja.modyfikuj(termin,zyczenie,zadatek))
             {
        
             return true;
             } 
             return false;
           
         }
//         System.out.println("Brak rezerwacji");
         return false;
     }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPesel() {
        return pesel;
    }
    

    public String getImieKlienta() {
        return imieKlienta;
    }

    public void setImieKlienta(String imieKlienta) {
        this.imieKlienta = imieKlienta;
    }

    public String getNazwiskoKlienta() {
        return nazwiskoKlienta;
    }

    public void setNazwiskoKlienta(String nazwiskoKlienta) {
        this.nazwiskoKlienta = nazwiskoKlienta;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(int nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public ArrayList getRezerwacje() {
        return rezerwacje;
    }
    
    public int getIloscRezerwacji() {
        return rezerwacje.size();
    }

    
    public void zarezerwuj(Rezerwacja rezerwacja)
    {       
       this.dodajRezerwacje(rezerwacja);
//       System.out.println("rezerwacje klienta: "+rezerwacje);
   
    }
    
    
    public void setRezerwacje(ArrayList rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
    
    public void dodajRezerwacje(Rezerwacja rezerwacja){
        this.rezerwacje.add(rezerwacja);
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
       Klient other = (Klient) obj;
        if (!Objects.equals(this.pesel, other.pesel)) {
            return false;
        }
        return true;
    }

   @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.pesel);
        return hash;
    }

    @Override
    public String toString() {
        return "Klient{" + "imieKlienta=" + imieKlienta + ", nazwiskoKlienta=" + nazwiskoKlienta + ", pesel=" + pesel + ", nrTelefonu=" + nrTelefonu + ", rezerwacje=" + rezerwacje + '}'+"\n";
    }

}