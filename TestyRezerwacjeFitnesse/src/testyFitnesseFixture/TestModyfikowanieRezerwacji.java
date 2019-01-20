package testyFitnesseFixture;

import fit.ColumnFixture;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import systemRezerwacjiPokoi.model.SpecjalneZyczenie;
import systemRezerwacjiPokoi.model.Zadatek;

public class TestModyfikowanieRezerwacji extends ColumnFixture {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String daneKlienta[], daneZyczenie[];
    String daneTermin, dataZadatek; 
    int nrRezerwacji,wartoscZadatek;
    Zadatek zadatek;
    SpecjalneZyczenie zyczenie = new SpecjalneZyczenie(daneZyczenie);

    public boolean modyfikujRezerwacje() throws ParseException {
        this.zadatek = new Zadatek(wartoscZadatek, sdf.parse(dataZadatek));
        return SetUp.aplikacja.modyfikujRezerwacje(daneKlienta, nrRezerwacji, daneTermin, zadatek, zyczenie);
    }

}
