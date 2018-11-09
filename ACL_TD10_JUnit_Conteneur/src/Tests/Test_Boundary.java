import Conteneur.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Test_Boundary {

	@Test(expected = ErreurConteneur.class)
	public void addNull() throws ErreurConteneur{

		Conteneur c = new ConteneurImpl(1);

		c.ajouter(null);
	}

	@Test(expected = ErreurConteneur.class)
	public void add2Same() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(1);

		String s = "Mon objet";

		c.ajouter(s);
		c.ajouter(s);
	}

	@Test(expected = ErreurConteneur.class)
	public void add2Equals() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(2);

		String s = "Mon objet";
		String s2 = "Mon objet";

		c.ajouter(s);
		c.ajouter(s2);
	}

	@Test
	public void add2in2() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(2);

		String s = "Mon objet";
		String s2 = "Mon objet2";

		c.ajouter(s);
		c.ajouter(s2);

		assertEquals(c.estVide(), false);
		assertEquals(c.contient(s), true);
		assertEquals(c.contient(s2), true);

	}

	@Test(expected = ErreurConteneur.class)
	public void add2in1() throws ErreurConteneur {
		Conteneur c = new ConteneurImpl(1);

		String s = "Mon objet";
		String s2 = "Mon objet2";

		c.ajouter(s);
		c.ajouter(s2);
	}
}
