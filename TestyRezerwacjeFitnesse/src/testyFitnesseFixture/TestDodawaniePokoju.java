package testyFitnesseFixture;
import fit.ColumnFixture;
public class TestDodawaniePokoju extends ColumnFixture{
 String dane[];

 public boolean dodajPokoj() {
 int s1=liczbaPokoi();
 SetUp.aplikacja.dodajPokoj(dane);
 int s2=liczbaPokoi();
 return s1!=s2;

 }

 public int liczbaPokoi() {
 return SetUp.aplikacja.getPokoj().size();
 }
}
