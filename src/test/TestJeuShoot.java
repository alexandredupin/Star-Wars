package test;

import libtest.*;
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test de JeuShoot
 */

public class TestJeuShoot {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		JeuShoot j = new JeuShoot();
		Monstre monstre = j.getEnnemi();
		Vaisseau v = j.getJoueur();
		int s = j.getScore();
		boolean b=j.getPerdu();
		j.evoluer(0);
		j.setEnnemi(new Monstre(2,2));
		j.setJoueur(new Vaisseau(2,2));
		assertEquals("score nul au depart",s,0);
	}

	/**
	* gererCollision et il n'y a pas collision
	*/
	public void test_GererCollision_PasCollision() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();
		Monstre m=new Monstre(6,7);
		j.setEnnemi(m); //on déplace le monstre de (10,5) pour vérifier qu'un autre ne réapparaisse pas à cet endroit
		j.getJoueur().tirer();

		// methode testee
		j.gererCollision();

		// vérifie que le score n'augmente pas
		assertEquals("le score devrait être nul",0,j.getScore());
		// vérifie que le tir est toujours présent
		assertEquals("le tir ne devrait pas être détruit","T(0,5)",j.getJoueur().getTirCourant().toString());
		// vérifie que le monstre ne meurt pas
		assertEquals("un nouveau monstre ne devrait pas apparaitre en (10,5)","Monstre(6,7)",j.getEnnemi().toString());
	}

	/**
	* gererCollision et il y a collision
	*/
	public void test_GererCollision_AvecCollision() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();
		Vaisseau v=new Vaisseau(8,8);
		Monstre m=new Monstre(8,8);
		j.setJoueur(v);
		j.setEnnemi(m); // on place le vaisseau (et donc le tir) et le monstre au même endroit
		j.getJoueur().tirer();

		// methode testee
		j.gererCollision();

		// vérifie que le score augmente
		assertEquals("le score devrait être de 1",1,j.getScore());
		// vérifie que le tir est détruit
		assertEquals("le tir devrait être détruit",null,j.getJoueur().getTirCourant());
		// vérifie que le monstre meurt et qu'un autre réapparait
		assertEquals("un nouveau monstre devrait apparaitre en (10,5)","Monstre(10,5)",j.getEnnemi().toString());
	}

	/**
	* évoluer et le vaisseau se déplace
	*/
	public void test_Evoluer_Deplacement() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();

		// methode testee
		j.evoluer(6);

		// vérifie que le vaisseau se déplace à droite
		assertEquals("le vaisseau devrait se déplacer d'une case vers la droite","Vaisseau(1,5)",j.getJoueur().toString());

		// methode testee
		j.evoluer(4);

		// vérifie que le vaisseau se déplace à gauche
		assertEquals("le vaisseau devrait se déplacer d'une case vers la gauche","Vaisseau(0,5)",j.getJoueur().toString());


		// methode testee
		j.evoluer(8);

		// vérifie que le vaisseau se déplace en haut
		assertEquals("le vaisseau devrait se déplacer d'une case vers le haut","Vaisseau(0,4)",j.getJoueur().toString());


		// methode testee
		j.evoluer(2);

		// vérifie que le vaisseau se déplace en bas
		assertEquals("le vaisseau devrait se déplacer d'une case vers le bas","Vaisseau(0,5)",j.getJoueur().toString());
	}

	/**
	* évoluer et le vaisseau crée un tir
	*/
	public void test_Evoluer_CreationTirEtAvancement() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();

		// methode testee
		j.evoluer(5); // un tir est crée en (0,5) et est évolué

		// vérifie que le tir avance bien en (1,5)
		assertEquals("un tir devrait avancer d'une case vers la droite","T(1,5)",j.getJoueur().getTirCourant().toString());
	}

	/**
	* évoluer et le monstre n'a pas parcouru toute l'arène
	*/
	public void test_Evoluer_AreneNonTraversee() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();

		// methode testee
		j.evoluer(4);

		// vérifie que perdu est false
		assertEquals("le jeu ne devrait pas s'arrêter",false,j.getPerdu());
	}

	/**
	* évoluer et le monstre a parcouru toute l'arène
	*/
	public void test_Evoluer_AreneTraversee() {
		// preparation des donnees
		JeuShoot j=new JeuShoot();
		Monstre m=new Monstre(1,0); // on place le monstre une case avant la fin
		j.setEnnemi(m);

		// methode testee
		j.evoluer(4);

		// vérifie que perdu est true
		assertEquals("le jeu devrait s'arrêter",true,j.getPerdu());
	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeuShoot(), args);
	}

}
