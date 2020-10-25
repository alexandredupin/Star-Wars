package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Monstre
 */
 
public class TestMonstre {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Monstre m = new Monstre(2, 3);
		boolean b = m.avoirCollision(new Tir(2, 2));
		b = m.avoirTraverse();
		m.evoluer();
		b = m.getEtreMort();
		int x = m.getX();
		int y = m.getY();
	}

	/**
	* évoluer et le monstre arrive au bord de l'arène
	*/
	public void test_Evoluer_BordArene() {
		// preparation des donnees
		Monstre m=new Monstre(10,0);

		// methode testee
		m.evoluer();

		// vérifie que le monstre tourne à gauche
		assertEquals("le monstre devrait tourner à gauche","Monstre(9,0)",m.toString());
	}

	/**
	* évoluer et le monstre se déplace vers le haut
	*/
	public void test_Evoluer_DeplacerHaut() {
		// preparation des donnees
		Monstre m=new Monstre(10,5);

		// methode testee
		m.evoluer();

		// vérifie que le monstre monte bien d'une case
		assertEquals("le monstre devrait monter d'une case","Monstre(10,4)",m.toString());
	}

	/**
	* évoluer et le monstre se déplace vers le bas
	*/
	public void test_Evoluer_DeplacerBas() {
		// preparation des donnees
		Monstre m=new Monstre(10,0);
		m.evoluer(); //le monstre est maintenant en (9,0) et deplacerHaut vaut false, on peut ainsi tester si le monstre se déplace bien vers le bas

		// methode testee
		m.evoluer();

		// vérifie que le monstre descend bien d'une case
		assertEquals("le monstre devrait descendre d'une case","Monstre(9,1)",m.toString());
	}

	/**
	* avoirTraversé et le monstre est au centre de l'arène
	*/
	public void test_AvoirTraverse_MonstreDansArene() {
		// preparation des donnees
		Monstre m=new Monstre(5,5);

		// methode testee
		boolean bool=m.avoirTraverse();

		// vérifie que avoirTraverse renvoie bien false
		assertEquals("le monstre ne devrait pas avoir traversé l'arène",false,bool);
	}


	/**
	* avoirTraversé et le monstre est tout à gauche de l'arène
	*/
	public void test_AvoirTraverse_MonstreAuBout() {
		// preparation des donnees
		Monstre m=new Monstre(0,0);

		// methode testee
		boolean bool=m.avoirTraverse();

		// vérifie que avoirTraverse renvoie bien true
		assertEquals("le monstre devrait avoir traversé l'arène",true,bool);
	}

	/**
	* avoirCollision et il n'y a pas collision entre le tir et le monstre
	*/
	public void test_AvoirCollision_PasCollision() {
		// preparation des donnees
		Monstre m=new Monstre(4,8);
		Tir t=new Tir(2,6);

		// methode testee
		boolean bool=m.avoirCollision(t);

		// vérifie que avoirCollision renvoie bien false
		assertEquals("le tir et le monstre ne devrait pas entrer en collision",false,bool);
	}

	/**
	* avoirCollision et il y a collision entre le tir et le monstre
	*/
	public void test_AvoirCollision_AvecCollision() {
		// preparation des donnees
		Monstre m=new Monstre(4,8);
		Tir t=new Tir(4,8);

		// methode testee
		boolean bool=m.avoirCollision(t);

		// vérifie que avoirCollision renvoie bien true
		assertEquals("le tir et le monstre devrait entrer en collision",true,bool);
	}

	/**
	* toString
	*/
	public void test_ToString() {
		// preparation des donnees
		Monstre m=new Monstre(8,2);

		// methode testee
		String chaineTest=m.toString();

		// verifie retour chaineTest
 	 	assertEquals("toString devrait renvoyer les bonnes coordonnées de Monstre","Monstre(8,2)",chaineTest);
 	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestMonstre(), args);
	}

}
