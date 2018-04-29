import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private List<Bateau> flotte; // liste de Bateau
	
	public List<Bateau> getFlotte() {
		return flotte;
	}
	
	private Grille zoneFlotte, zoneTire;
	
	public Grille getZoneFlotte() {
		return zoneFlotte;
	}
	public Grille getZoneTire() {
		return zoneTire;
	}

	public Joueur(Grille grille) {
		this(grille, new ArrayList<Bateau>());
	}
	
	public Joueur(Grille grille, List<Bateau> flotte) {
		this.zoneFlotte = (Grille)grille.clone();
		this.zoneTire = (Grille)grille.clone();
		this.flotte = new ArrayList<>(flotte);
	}
	
	public boolean ajouterBateau (Bateau bateau) {
		for(Bateau b : flotte)
			for(Point p : bateau.getPoints())
				if(p.inSegment(b.getCoorDebut(), b.getCoorFin())) { 
					System.out.println(" ce bateau se supperpose avec un autre !");
		return false;}
		
		for(Point p : bateau.getPoints())
			if(p.inSegment(new Point(0, 0),new Point (zoneFlotte.getLargeur(),zoneFlotte.getLongueur()))){ 
				return false;}
		
		flotte.add(bateau);
		for(int y = bateau.getCoorDebut().getY(); y <= bateau.getCoorFin().getY(); y++)
			for(int x = bateau.getCoorDebut().getX(); x <= bateau.getCoorFin().getX(); x++)
				zoneFlotte.getCellule(y, x).setVal(Valeur.bateau);
		return true;
	}

	public void supprimerBateau (Bateau b) {
		flotte.remove(b);
	}
	
	public Bateau recupererBateau (Point p) {
		for ( Bateau b : flotte)
			if ( p.inSegment(b.getCoorDebut(),b.getCoorFin()))
				return b;
		return null;
	}
	
	public void rapportAttaque(Point p, Valeur resultat, Joueur ennemi) {
		if(resultat == Valeur.coule) {
			Bateau b = ennemi.recupererBateau(p);
			for(Cellule c : ennemi.zoneFlotte.etenduBateau(b))
				zoneTire.getCellule(c.getCoord().getX(), c.getCoord().getY()).setVal(Valeur.coule);
			ennemi.flotte.remove(b);
		}
		else zoneTire.getCellule(p.getX(), p.getY()).setVal(resultat);
	}
	
	public Valeur subirAttaque(Point p) {
		Valeur retour = zoneFlotte.getCellule(p.getX(), p.getY()).getVal();
		if(retour == Valeur.vide)
			retour = Valeur.tire;
		if(retour == Valeur.bateau) {
			Bateau b = recupererBateau(p);
			if(p != null && b.getPtVie() > 1) {
				b.setPtVie(b.getPtVie() - 1);
				retour = Valeur.touche;
			} else if(p != null) {
				for(Cellule c : zoneFlotte.etenduBateau(b))
					c.setVal(Valeur.coule);
				retour = Valeur.coule;
			}
		}
		zoneFlotte.getCellule(p.getX(), p.getY()).setVal(retour);
		return retour;
	}
	
	public int valeurPoint(Point p, boolean attaque) {
		Grille zone = (attaque) ? zoneTire : zoneFlotte;
		return zone.valeurCellule(p);
	}
}

