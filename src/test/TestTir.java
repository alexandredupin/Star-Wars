package test;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;
import application.*;

/**
 * test classe Tir
 */

public class TestTir {

	/**
	 * test initial pour verifier le bon appel des methodes
	 */
	public void test_initial() {
		Tir t = new Tir(5,6);
		assertEquals("test X", 5, t.getX());
		assertEquals("test Y", 6, t.getY());
		t.evoluer();
	}


	/**
	 * evoluer et le tir reste dans l'arene
	 */
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Tir t=new Tir(6, 5);

		// methode testee
		boolean res=t.evoluer();

		// verifie retour false
		assertEquals("tir devrait rester dans arene", false, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 7, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}



	/**
	 * evoluer et le tir sort de l'arene
	 */
	public void test_Evoluer_SortirArene() {
		// preparation des donnees
		Tir t=new Tir(10, 5);

		// methode testee
		boolean res=t.evoluer();

		// verifie retour true car sortie de l arene
		assertEquals("tir devrait rester dans arene", true, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 11, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	 * toString
	 */
	 public void test_ToString() {
		// preparation des donnees
		Tir t=new Tir(10,5);

		// methode testee
		String chaineTest=t.toString();

		// verifie retour chaineTest
		assertEquals("toString devrait renvoyer les bonnes coordonnées de Tir","T(10,5)",chaineTest);
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestTir(), args);
	}

}
