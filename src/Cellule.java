
public class Cellule {

	private Point coord; 
	private Valeur val;
	
	public Point getCoord() {
		return coord;
	}
	public void setCoord(Point coord) {
		this.coord = coord;
	}
	public Valeur getVal() {
		return val;
	}
	public void setVal(Valeur val) {
		this.val = val;
	}
	
	public Cellule (Point p) {
		this(p, Valeur.vide);
	}
	public Cellule (Point p , Valeur val) {
		this.coord=p;
		this.val= val;
	}
	
	@Override
	public String toString() {
		return val+"";
	}
}
