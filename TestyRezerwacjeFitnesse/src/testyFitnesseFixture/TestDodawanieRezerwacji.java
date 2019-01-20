package testyFitnesseFixture;

import fit.ColumnFixture;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import systemRezerwacjiPokoi.model.SpecjalneZyczenie;
import systemRezerwacjiPokoi.model.Zadatek;

public class TestDodawanieRezerwacji extends ColumnFixture {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String daneKlienta[], danePokoju[], daneZyczenie[];
    String daneTermin, dataZadatek; 
    int wartoscZadatek;
    Zadatek zadatek;
    SpecjalneZyczenie zyczenie = new SpecjalneZyczenie(daneZyczenie);

    public boolean dodajRezerwacje() throws ParseException {
        this.zadatek = new Zadatek(wartoscZadatek, sdf.parse(dataZadatek));
        return SetUp.aplikacja.dodajRezerwacje(daneKlienta, danePokoju, daneTermin, zadatek, zyczenie);
    }

    public int liczbaRezerwacjiKlienta() {
        return SetUp.aplikacja.getKlient().get(0).getRezerwacje().size();
    }

    public int liczbaRezerwacjiPokoju() {
        return SetUp.aplikacja.getPokoj().get(0).getRezerwacje().size();
    }
}
