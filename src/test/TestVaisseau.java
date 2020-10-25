package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Vaisseau
 */

public class TestVaisseau {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Vaisseau v = new Vaisseau();
		v = new Vaisseau(1, 2);
		v.evoluerTir();
		v.faireAction(0);
		Tir t = v.getTirCourant();
		v.getX();
		v.getY();
		v.tirer();
	}


	/**
	* tirer
	*/
	public void test_Tirer() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(3,3);

		// methode testee
		v.tirer();

		// vérifie que le tir existe et qu'il est bien situé
		assertEquals("le tir devrait exister en (3,3)","T(3,3)",v.getTirCourant().toString());
	}

	/**
	* faireAction
	*/
	public void test_FaireAction() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(4,4);
		Tir t=new Tir(4,4);

		// methode testee
		v.faireAction(4);

		// vérifie position du vaisseau après évolution
		assertEquals("le vaisseau devrait se déplacer d'une case vers la gauche","Vaisseau(3,4)",v.toString());


		// methode testee
		v.faireAction(6);

		// vérifie position du vaisseau après évolution
		assertEquals("le vaisseau devrait se déplacer d'une case vers la droite","Vaisseau(4,4)",v.toString());


		// methode testee
		v.faireAction(8);

		// vérifie position du vaisseau après évolution
		assertEquals("le vaisseau devrait se déplacer d'une case vers le haut","Vaisseau(4,3)",v.toString());


		// methode testee
		v.faireAction(2);

		// vérifie position du vaisseau après évolution
		assertEquals("le vaisseau devrait se déplacer d'une case vers le bas","Vaisseau(4,4)",v.toString());


		// methode testee
		v.faireAction(5);

		// vérifie création du tir
		assertEquals("le tir devrait exister en (4,4)",t.toString(),v.getTirCourant().toString());
	}

	/**
	* detruireTir et il n'y a pas de tirCourant
	*/
	public void test_DetruireTir_SansTirCourant() {
		// preparation des donnees
		Vaisseau v=new Vaisseau();

		// methode testee
		v.detruireTir();

		// vérifie qu'il n'y a pas de tirCourant
		assertEquals("le tir ne devrait pas exister",null,v.getTirCourant());
	}

	/**
	* detruireTir et il y a un tirCourant
	*/
	public void test_DetruireTir_AvecTirCourant() {
		// preparation des donnees
		Vaisseau v=new Vaisseau();
		v.tirer();

		// methode testee
		v.detruireTir();

		// vérifie qu'il n'y a plus de tirCourant
		assertEquals("le tir n'a pas été détruit",null,v.getTirCourant());
	}

	/**
	* evoluerTir et le tir sort de l'arène
	*/
	public void test_EvoluerTir_SortirArene() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(10,2);
		v.tirer();

		// methode testee
		v.evoluerTir();

		// vérifie que le tir est bien détruit
		assertEquals("le tir devrait sortir de l'arène et être détruit",null,v.getTirCourant());
	}

	/**
	* evoluerTir et le tir reste dans l'arène
	*/
	public void test_EvoluerTir_ResterDansArene() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(6,2);
		v.tirer();

		// methode testee
		v.evoluerTir();

		// vérifie que le tir avance bien d'une case
		assertEquals("le tir devrait avancer d'une case","T(7,2)",v.getTirCourant().toString());
	}

	/**
	* toString et il n'y a pas de tirCourant
	*/
	public void test_ToString_SansTirCourant() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(3,8);

		// methode testee
		String chaineTest=v.toString();

		// verifie retour chaineTest
		assertEquals("toString devrait renvoyer les bonnes coordonnées de Vaisseau et uniquement celles de Vaisseau","Vaisseau(3,8)",chaineTest);
	}

	/**
	* toString et il y a un tirCourant
	*/
	public void test_ToString_AvecTirCourant() {
		// preparation des donnees
		Vaisseau v=new Vaisseau(4,2);

		// methode testee
		v.tirer();

		// verifie retour chaineTest
		assertEquals("toString devrait renvoyer les bonnes coordonnées de Vaisseau et celles de tirCourant","Vaisseau(4,2)-T(4,2)",v.toString());
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestVaisseau(), args);
	}

}
