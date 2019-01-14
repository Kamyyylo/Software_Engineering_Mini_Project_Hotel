
package Suite;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import systemRezerwacjiPokoi.AplikacjaTest;
import systemRezerwacjiPokoi.model.KlientTest;
import systemRezerwacjiPokoi.model.PokojTest;

/**
 *
 * @author Tomek
 */

@SuiteClasses({AplikacjaTest.class, KlientTest.class, PokojTest.class})

@RunWith(Suite.class)
public class RezerwacjeTestSuite {}
