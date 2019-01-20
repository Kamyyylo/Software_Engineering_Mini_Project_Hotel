package testyFitnesseFixture;
import fit.ColumnFixture;
public class TestDodawanieKlienta extends ColumnFixture{
 String dane[];

 public boolean dodajKlienta() {
 int s1=liczbaKlientow();
 SetUp.aplikacja.dodajKlienta(dane);
 int s2=liczbaKlientow();
 return s1!=s2;

 }

 public int liczbaKlientow() {
 return SetUp.aplikacja.getKlient().size();
 }
}