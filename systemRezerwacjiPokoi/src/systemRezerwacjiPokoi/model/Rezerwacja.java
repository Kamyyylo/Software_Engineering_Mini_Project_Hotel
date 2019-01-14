package systemRezerwacjiPokoi.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rezerwacja {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        private int nrRezerwacji;
	private Date termin;
	private Zadatek zadatek;
	private Pokoj pokoj;
	private Klient klient;
	private SpecjalneZyczenie zyczenia;


    public Rezerwacja(int nrRezerwacji, Date termin, Zadatek zadatek, Pokoj pokoj, Klient klient, SpecjalneZyczenie zyczenia) {
            this.nrRezerwacji = nrRezerwacji;
            this.termin= termin;
            this.zadatek = zadatek;
            this.pokoj = pokoj;
            this.klient = klient;
            this.zyczenia = zyczenia;
        }

   public  Rezerwacja(){
        this.nrRezerwacji = -1;
        this.termin = null;
        this.zadatek = null;
        this.pokoj = null;
        this.klient = null;
        this.zyczenia = null;
    }
    public Rezerwacja(int nrRez,Date termin, Zadatek zadatek, SpecjalneZyczenie zyczenie){
        this.nrRezerwacji = nrRez;
        this.termin = termin;
        this.zadatek = zadatek;
        this.pokoj = null;
        this.klient = null;
        this.zyczenia = zyczenie;
    }

//    
//    public void modyfikuj(Date termin,SpecjalneZyczenie zyczenie, Zadatek zadatek )       //modyfikowanie rezerwacji
//    {
//        
//     
//    }

    public int getNrRezerwacji() {
        return nrRezerwacji;
    }

    public void setNrRezerwacji(int nrRezerwacji) {
        this.nrRezerwacji = nrRezerwacji;
    }

    @Override
    public String toString() {
        return "Rezerwacja{" + "nrRezerwacji=" + nrRezerwacji + ", termin=" + termin + ", zadatek=" + ", zyczenia=" + zyczenia + '}';
    }

 

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }
    public boolean porownajTermin(Date terminTmp){
     return this.termin.equals(terminTmp);                    //jesli true to zajety termin
    
}
   

public Zadatek getZadatek() {
        return zadatek;
    }

    public void setZadatek(Zadatek zadatek) {
        this.zadatek = zadatek;
    }

    public Pokoj getPokoj() {
        return pokoj;
    }

    public void setPokoj(Pokoj pokoj) {
        this.pokoj = pokoj;
    }

    public SpecjalneZyczenie getZyczenia() {
        return zyczenia;
    }

    public void setZyczenia(SpecjalneZyczenie zyczenia) {
        this.zyczenia = zyczenia;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
    
@Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.nrRezerwacji;
        return hash;
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
        final Rezerwacja other = (Rezerwacja) obj;
        if (this.nrRezerwacji != other.nrRezerwacji) {
            return false;
        }
      
        return true;
    }
    
    public boolean modyfikuj(Date termin, SpecjalneZyczenie zyczenie, Zadatek zadatek)
    {
        
       if(pokoj.modyfikuj(termin, zyczenia, zadatek))
       {this.termin = termin;
        this.zyczenia = zyczenie;
        this.zadatek=zadatek;
       return true;
       }
        return false;
    }
}