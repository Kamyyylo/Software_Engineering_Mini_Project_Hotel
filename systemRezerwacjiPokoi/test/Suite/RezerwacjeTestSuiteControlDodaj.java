
package Suite;


import org.junit.runner.RunWith;
import systemRezerwacjiPokoi.TestControl;
import org.junit.experimental.categories.Categories;
import systemRezerwacjiPokoi.AplikacjaTest;
import systemRezerwacjiPokoi.TestModyfikacja;
import systemRezerwacjiPokoi.model.KlientTest;
import systemRezerwacjiPokoi.model.PokojTest;

@Categories.SuiteClasses({AplikacjaTest.class, KlientTest.class, PokojTest.class})

@RunWith(Categories.class)
@Categories.IncludeCategory(TestControl.class)
@Categories.ExcludeCategory(TestModyfikacja.class)
public class RezerwacjeTestSuiteControlDodaj {}
