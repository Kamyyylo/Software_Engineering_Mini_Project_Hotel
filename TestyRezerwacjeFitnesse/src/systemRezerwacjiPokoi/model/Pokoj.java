package systemRezerwacjiPokoi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Pokoj {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private int nrPokoju;
    private int wielkoscPokoju;
    private String standardPokoju;
    private int cenaPokoju;
    private ArrayList<Rezerwacja> rezerwacje = new ArrayList();

    public Pokoj() {
        this.nrPokoju = -1;
        this.wielkoscPokoju = -1;
        this.standardPokoju = "";
        this.cenaPokoju = -1;
    }

    public Pokoj(int nrPokoju, int wielkoscPokoju, String standardPokoju, int cenaPokoju, ArrayList<Rezerwacja> rezerwacje) {
        this.nrPokoju = nrPokoju;
        this.wielkoscPokoju = wielkoscPokoju;
        this.standardPokoju = standardPokoju;
        this.cenaPokoju = cenaPokoju;
        this.rezerwacje = rezerwacje;
    }

    public Pokoj(int nrPokoju, int wielkoscPokoju, String standardPokoju, int cenaPokoju) {
        this.nrPokoju = nrPokoju;
        this.wielkoscPokoju = wielkoscPokoju;
        this.standardPokoju = standardPokoju;
        this.cenaPokoju = cenaPokoju;

    }
    
    public Pokoj(String[] danePokoju) {
        this.nrPokoju = Integer.parseInt(danePokoju[0]);
        this.wielkoscPokoju = Integer.parseInt(danePokoju[1]);
        this.standardPokoju = danePokoju[2];
        this.cenaPokoju = Integer.parseInt(danePokoju[3]);

    }

    public Pokoj(int wielkoscPokoju, String standardPokoju) {
        this.wielkoscPokoju = wielkoscPokoju;
        this.standardPokoju = standardPokoju;
    }

    public boolean zarezerwuj(Klient eKlient, int nrRezerwacji, Date termin, Zadatek zadatek, SpecjalneZyczenie specjalneZyczenie) {

        boolean rezultat;
        rezultat = sprawdzCzyJestWolny(termin);
        if (rezultat) {
            Rezerwacja rezerwacja = new Rezerwacja(nrRezerwacji, termin, zadatek, specjalneZyczenie);
            rezerwacja.setPokoj(this);
            this.rezerwacje.add(rezerwacja);
            eKlient.zarezerwuj(rezerwacja);
//            System.out.println("udalo sie zarezerwowac");
            return true;

        }
//        System.out.println("brak terminu");
        return false;

    }

    public Rezerwacja szukajRezerwacji(Rezerwacja tmp) {

        int idx = this.rezerwacje.indexOf(tmp);
        if (idx != -1) {
            return this.rezerwacje.get(idx);
        }
        return null;
    }

    public boolean sprawdzCzyJestWolny(Date termin) {       //funkcja sprawdzajaca czy rezerwacja sie pokrywa

        for (int i = 0; i < rezerwacje.size(); i++) {
            if (rezerwacje.get(i).porownajTermin(termin)) //jesli true to zajety termin
            {
                return false;
            }
        }

        return true;                                       //termin wolny zwraca true
        
    }

    public boolean modyfikuj(Date termin) {
        boolean rezultat;
        rezultat = this.sprawdzCzyJestWolny(termin);
        if (rezultat) {
            return true;
        }

//        System.out.println("brak terminu");
        return false;
    }

    public void setWielkoscPokoju(int wielkoscPokoju) {
        this.wielkoscPokoju = wielkoscPokoju;
    }

    public void setStandardPokoju(String standardPokoju) {
        this.standardPokoju = standardPokoju;
    }

    public int getWielkoscPokoju() {
        return wielkoscPokoju;
    }

    public String getStandardPokoju() {
        return standardPokoju;
    }

    public int getNrPokoju() {
        return nrPokoju;
    }

    public void setNrPokoju(int nrPokoju) {
        this.nrPokoju = nrPokoju;
    }

    public int getCenaPokoju() {
        return cenaPokoju;
    }

    public void setCenaPokoju(int cenaPokoju) {
        this.cenaPokoju = cenaPokoju;
    }

    public ArrayList getRezerwacje() {
        return rezerwacje;
    }


    public void setRezerwacje(ArrayList rezerwacje) {
        this.rezerwacje = rezerwacje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.wielkoscPokoju;
        hash = 41 * hash + Objects.hashCode(this.standardPokoju);
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
        final Pokoj other = (Pokoj) obj;
        if (this.wielkoscPokoju != other.wielkoscPokoju) {
            return false;
        }
        if (!Objects.equals(this.standardPokoju, other.standardPokoju)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Pokoj{" + "nrPokoju=" + nrPokoju + ", wielkoscPokoju=" + wielkoscPokoju + ", standardPokoju=" + standardPokoju + ", cenaPokoju=" + cenaPokoju + ", rezerwacje" + rezerwacje + '}';
    }

    public boolean equals(int wielkoscPokoju, String standardPokoju) {
        if (this.wielkoscPokoju == wielkoscPokoju && this.standardPokoju.equals(standardPokoju)) {
            return true;
        }
        return false;

    }

}
