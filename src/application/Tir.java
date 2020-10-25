package application;

public class Tir {

  private int x,y; //coordonnées du tir (x pour l'abscisse et y pour l'ordonnée)

  /** construit un objet Tir
  *@param px abscisse du tir
  *@param py ordonnée du tir
  */
  public Tir(int px,int py) {
    this.x=px;
    this.y=py;
  }

  /** méthode qui renvoie l'attribut x
  *@return x abscisse du tir
  */
  public int getX() {
    return this.x;
  }

  /** méthode qui renvoie l'attribut y
  *@return y ordonnée du tir
  */
  public int getY() {
    return this.y;
  }

  /** méthode qui avance le tir d'une case et indique si le tir sort de l'arène
  *@return tirSorti
  */
  public boolean evoluer() {
    boolean tirSorti;
    this.x++;
    if (x>=11)
      tirSorti=true;
    else
      tirSorti=false;
    return tirSorti;
  }

  /** méthode qui affiche les coordonées du tir
  *@return ch chaine de la forme T(x,y)
  */
  public String toString() {
    String ch="T("+getX()+","+getY()+")";
    return ch;
  }


}
