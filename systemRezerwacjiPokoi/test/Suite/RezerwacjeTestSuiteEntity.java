
package Suite;

import org.junit.runner.RunWith;

import org.junit.experimental.categories.Categories;
import systemRezerwacjiPokoi.AplikacjaTest;
import systemRezerwacjiPokoi.TestEntity;
import systemRezerwacjiPokoi.model.KlientTest;
import systemRezerwacjiPokoi.model.PokojTest;

@Categories.SuiteClasses({AplikacjaTest.class, KlientTest.class, PokojTest.class})

@RunWith(Categories.class)
@Categories.IncludeCategory(TestEntity.class)
public class RezerwacjeTestSuiteEntity {}
