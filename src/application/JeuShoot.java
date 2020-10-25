package application;

import java.util.Scanner;

public class JeuShoot {

  private Vaisseau joueur; // représente le vaisseau du joueur
  private Monstre ennemi; // représente l'ennemi affronté par le joueur (s'il est touché, il disparait et est remplacé par un autre ennemi)
  private int score; // représente le score du joueur, il s'incrémente de 1 à chaque ennemi tué
  private boolean perdu; // permet de détecter la fin de partie

  /** construit un objet JeuShoot qui initialise le joueur en (0,5), l'ennemi en (10,5), le score à 0 et perdu à false
  */
  public JeuShoot() {
    this.joueur=new Vaisseau(0,5);
    this.ennemi=new Monstre(10,5);
    this.score=0;
    this.perdu=false;
  }

  /** méthode qui renvoie l'attribut joueur
  *@return joueur (coordonnées du vaisseau)
  */
  public Vaisseau getJoueur() {
    return this.joueur;
  }

  /** méthode qui renvoie l'attribut ennemi
  *@return ennemi (coordonnées du monstre)
  */
  public Monstre getEnnemi() {
    return this.ennemi;
  }

  /** méthode qui renvoie l'attribut perdu
  *@return perdu (booléen qui détermine si la partie est finie ou non)
  */
  public boolean getPerdu() {
    return this.perdu;
  }

  /** méthode qui renvoie l'attribut score du joueur
  *@return score
  */
  public int getScore() {
    return this.score;
  }

  /** méthode qui permet de modifier facilement le monstre du jeu
  *@param m Monstre à mettre dans l'attribut ennemi
  */
  public void setEnnemi(Monstre m) {
    this.ennemi=m;
  }

  /** méthode qui permet de modifier facilement le vaisseau du jeu
  *@param v Vaisseau à mettre dans l'attribut joueur
  */
  public void setJoueur(Vaisseau v) {
    this.joueur=v;
  }

  /** méthode qui vérifie si le tir du joueur entre en collision avec l'ennemi
  * si c'est le cas, alors le score augmente de 1, un nouveau monstre apparait en (10,5) et le tir est détruit
  */
  public void gererCollision() {
    if (this.ennemi.avoirCollision(this.joueur.getTirCourant())==true) {
      this.score++;
      this.ennemi=new Monstre(10,5);
      this.joueur.detruireTir();
    }
  }

  /** méthode qui fait évoluer le jeu
  * le vaisseau fait l'action voulue par le joueur (se déplacer ou tirer), le tir avance, on vérifie qu'il n'y ait pas de collision, le monstre avance, on révérifie la potentielle collision Monstre-Tir, et enfin si le monstre arrive au bout, l'attribut perdu est mis à jour (et le jeu s'arrête)
  *@param commande action voulue
  */
  public void evoluer(int commande) {
    this.joueur.faireAction(commande);
    this.joueur.evoluerTir();
    gererCollision();
    ennemi.evoluer();
    gererCollision();
    if (ennemi.avoirTraverse()==true) {
      this.perdu=true;
    }
  }

  /** méthode qui demande au joueur l'action qu'il souhaite faire
  *@return cmd commande voulue
  */
  public int demanderJoueur() {
    Scanner sc=new Scanner(System.in);
    int cmd=sc.nextInt();
    return cmd;
  }

  /** méthode qui exécute la méthode evoluer avec le résultat de la méthode demanderJoueur
  * et affiche le contenu du jeu après évolution
  */
  public void poursuivre() {
    evoluer(demanderJoueur());
    toString();
  }

  /** méthode qui décrit l'état du jeu
  *@return ch chaine de la forme  Vaisseau(x,y)
                                  Monstre (x,y)
                                  score
  */
  public String toString() {
    String ch=joueur.toString()+"\n"+ennemi.toString()+"\n"+this.score;
    return ch;
  }

  public void main() {
    while (this.perdu==false) {
      poursuivre();
    }
  }




}
