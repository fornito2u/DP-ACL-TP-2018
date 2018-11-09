import Conteneur.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Test_Right {

	@Test
	public void add1() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(1);

		String s = "MonObjet";

		c.ajouter(s);

		assertEquals(c.estVide(), false);
		assertEquals(c.contient(s), true);
	}

	@Test
	public void add2() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(2);

		String s = "MonObjet";
		String s2 = "MonObjet2";

		c.ajouter(s);
		c.ajouter(s2);


		assertEquals(c.estVide(), false);
		assertEquals(c.contient(s), true);
		assertEquals(c.contient(s2), true);
	}
}
