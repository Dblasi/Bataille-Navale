import java.util.ArrayList;
import java.util.List;

public class Grille implements Cloneable {
	
	private Cellule cellules[][];
	private int largeur;
	private int longueur;
	
	public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public Cellule getCellule(int x, int y) {
		return cellules[x][y];
	}
	
	public Grille (int largeur, int longueur){
		this.longueur = longueur;
		this.largeur = largeur;
		cellules = new Cellule[largeur][longueur];
		for(int x  = 0; x < largeur; x++)
			for(int y  = 0; y < longueur; y++) 
				cellules[x][y] = new Cellule(new Point(x, y));
	}
	
	@Override
	public String toString() {
		String retour = "X ", test = "";
		for (int i = 0; i < largeur; i++)
			retour += i+" ";
		retour += "\n";
		for(int y  = 0; y < longueur; y++) {
			//test = ((Integer)(y)).toString().length() < 2 ? " " : "";
			retour += /*test+*/(y)+" ";
			for(int x  = 0; x < largeur; x++) {
				retour += cellules[y][x]+" ";
			}
			retour += "\n";
		}
		return retour;
	}
	
	@Override
	protected Object clone() {
		return new Grille(this.largeur, this.longueur);
	}
	
	public int valeurCellule(Point p) {
		return getCellule(p.getX(),p.getY()).getVal().getValeur();
	}
	
	public List<Cellule> etenduBateau(Bateau b){
		List<Cellule> cellules = new ArrayList<>();
		for(int x = b.getCoorDebut().getX(); x <= b.getCoorFin().getX(); x++)
			for(int y = b.getCoorDebut().getY(); y <= b.getCoorFin().getY(); y++)
				cellules.add(getCellule(y, x));
		System.out.println(cellules);
		return cellules;
	}
}
