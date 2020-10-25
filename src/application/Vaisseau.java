package application;

public class Vaisseau {

  private int x,y; //coordonnées du vaisseau (x pour l'abscisse et y pour l'ordonnée)
  private Tir tirCourant; //tir effectué par le vaisseau

  /** construit un objet Vaisseau avec pour coordonées (5,5)
  */
  public Vaisseau() {
    this.x=5;
    this.y=5;
    this.tirCourant=null;
  }

  /** construit un objet Vaisseau aux coordonées données
  *@param px abscisse du vaisseau
  *@param py ordonnée du vaisseau
  *si les coordonées sont hors de l'arène, le vaisseau est placé en (5,5)
  */
  public Vaisseau(int px,int py) {
    if ((px>10) || (px<0) || (py>10) || (py<0)) {
      this.x=5;
      this.y=5;
    }
    else {
      this.x=px;
      this.y=py;
    }
    this.tirCourant=null;
  }

  /** méthode qui renvoie l'attribut tirCourant
  *@return tirCourant tir effectué par le vaisseau
  */
  public Tir getTirCourant() {
    return this.tirCourant;
  }

  /** méthode qui renvoie l'attribut x
  *@return x abscisse du vaisseau
  */
  public int getX() {
    return this.x;
  }

  /** méthode qui renvoie l'attribut y
  *@return y ordonnée du vaisseau
  */
  public int getY() {
    return this.y;
  }

  /** méthode qui déplace le vaisseau, à condition qu'il reste dans l'arène
  *@param dx déplacement horizontal et dy déplacement vertical
  */
  private void deplacer(int dx,int dy) {
    if ((this.x+dx<=10) && (this.x+dx>=0) && (this.y+dy<=10) && (this.y+dy>=0)) {
      this.x+=dx;
      this.y+=dy;
    }
  }

  /** méthode qui permet au vaisseau de tirer, c'est à dire qui crée un tirCourant aux coordonnées du vaisseau
  */
  public void tirer() {
    if (this.tirCourant==null) {
      this.tirCourant=new Tir(this.x,this.y);
    }
  }

  /** méthode qui déplace le vaisseau ou tente de lancer un tir
  *@param commande qui définit l'action à faire
  */
  public void faireAction(int commande) {
    switch(commande) {
      case 4:
        deplacer(-1,0);
        break;
      case 6:
        deplacer(1,0);
        break;
      case 8:
        deplacer(0,-1);
        break;
      case 2:
        deplacer(0,1);
        break;
      case 5:
        tirer();
        break;
    }
  }

  /** méthode qui détruit le tir en cours
  */
  public void detruireTir() {
    this.tirCourant=null;
  }

  /** méthode qui avance le tir d'une case
  * si le tir sort de l'arène, le tir est détruit
  */
  public void evoluerTir() {
    if (this.tirCourant!=null) {
      if (this.tirCourant.evoluer()==true) {
        detruireTir();
      }
    }
  }

  /** méthode qui renvoie les coordonées du vaisseau et du tir courant, s'il y en a un
  *@return ch chaine composée de "Vaisseau" suivi de ses coordonées
  */
  public String toString() {
    String ch="Vaisseau"+"("+this.x+","+this.y+")";
    if (this.tirCourant!=null) {
      ch+="-"+this.tirCourant.toString();
    }
    return ch;
  }

}
