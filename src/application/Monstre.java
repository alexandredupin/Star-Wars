package application;

public class Monstre {

  private int x,y; // coordonnées du monstre dans l'arène
  private boolean deplacerHaut; // direction de déplacement du monstre (true signifie vers le haut, et false vers le bas)
  private boolean etreMort; // vaut true si le monstre est mort

  /** construit un objet Monstre aux coordonnées données
  *@param px abscisse du monstre
  *@param py son ordonnée
  * si les coordonées sont hors de l'arène, le monstre est placé en (10,5)
  */
  public Monstre(int px,int py) {
    if ((px>10) || (px<0) || (py>10) || (py<0)) {
      this.x=10;
      this.y=5;
    }
    else {
      this.x=px;
      this.y=py;
    }
    this.deplacerHaut=true;
    this.etreMort=false;
  }

  /** méthode qui renvoie l'attribut etreMort
  *@return etreMort qui caractérise si le monstre est en vie ou non
  */
  public boolean getEtreMort() {
    return this.etreMort;
  }

  /** méthode qui renvoie l'attribut x
  *@return x abscisse du monstre
  */
  public int getX() {
    return this.x;
  }

  /** méthode qui renvoie l'attribut y
  *@return y ordonnée du monstre
  */
  public int getY() {
    return this.y;
  }

  /** méthode qui fait "avancer" le monstre
  * déplace le monstre d'une case vers le haut ou le bas, suivant son sens de déplacement
  * lorsque le monstre atteint le bord de l'arène, il se déplace d'une case vers la gauche et il change son sens de déplacement
  */
  public void evoluer() {
    if (this.etreMort==false) {
      if (this.deplacerHaut==true) {
        if (this.y==0) {
          this.deplacerHaut=false;
          this.x--;
        }
        else {
          this.y--;
        }
      }
      else {
        if (this.y==10) {
          this.deplacerHaut=true;
          this.x--;
        }
        else {
          this.y++;
        }
      }
    }
  }

  /** méthode qui permet de savoir si le monstre est arrivé tout en haut à gauche de l'arène (et donc que le joueur a perdu)
  *@return true si c'est le cas, false sinon
  */
  public boolean avoirTraverse() {
    if (this.x==0) {
      return true;
    }
    else {
      return false;
    }
  }

  /** méthode qui permet de savoir si il y a collision entre le monstre et le tir
  *@param t objet de type Tir
  *@return true si c'est le cas, false sinon
  */
  public boolean avoirCollision(Tir t) {
    if ((t!=null) && (t.getX()==this.x) && (t.getY()==this.y)) {
      this.etreMort=true;
      return true;
    }
    else {
      return false;
    }
  }

  /** méthode qui affiche les coordonées du monstre
  *@return ch chaine de la forme Vaisseau(x,y)
  */
  public String toString() {
    String ch="Monstre"+"("+this.x+","+this.y+")";
    return ch;
  }


}
