import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	
	public static void main(String[] args) {
		List<Bateau> bateaux = new ArrayList<>() {{
			/*add(new Bateau(TypeBateau.porte_avions));
			add(new Bateau(TypeBateau.croiseur));
			add(new Bateau(TypeBateau.contre_torpilleur));
			*/add(new Bateau(TypeBateau.sous_marin));
			add(new Bateau(TypeBateau.torpilleur));
		}};

		Grille g = new Grille(10, 10);
		Joueur J1 = new Joueur(g);
		Joueur J2 = new Joueur(g);

		
		boolean test;
		System.out.println("                   Bataille Navale à deux joueurs     ");
		System.out.println("Au tour du Joueur 1 :");
		for (Bateau b : bateaux){
			do {
				try {
					test = J1.ajouterBateau(positionner(b));
					System.out.println("Ma zone de flotte :\n"+J1.getZoneFlotte());
				} catch (Exception e) {
					test = false;
					System.out.println(e.getMessage());
				}
			} while(!test);
		}
		
			affichage();
		
		System.out.println("Au tour du Joueur 2 :");
		for (Bateau b : bateaux){
			do {
				try {
					test = J2.ajouterBateau(positionner(b));
					System.out.println("Ma zone de flotte :\n"+J2.getZoneFlotte());
				} catch (Exception e) {
					
					test = false;
					
				}
			} while(!test);
		}
		affichage();
		Point cible;
		do { affichage();
			System.out.println("Au tour du Joueur 1 :");
			System.out.println("votre zone de flotte :\n"+J1.getZoneFlotte());
			cible = cibler(J1.getZoneTire());
			J1.rapportAttaque(cible,J2.subirAttaque(cible),J2);
			if(J2.getFlotte().isEmpty()) break;
			affichage();
			System.out.println("Au tour du joueur 2 :");
			System.out.println("Votre zone de flotte :\n"+J2.getZoneFlotte());
			cible = cibler(J2.getZoneTire());
			J2.rapportAttaque(cible, J1.subirAttaque(cible),J1);
		} while(!J1.getFlotte().isEmpty() && !J2.getFlotte().isEmpty());
		
		if(J1.getFlotte().isEmpty())
			System.out.println("J2 a gagné");
		else if(J2.getFlotte().isEmpty())
			System.out.println("J1 a gagné");
	}
	
	public static Bateau positionner (Bateau b ) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisit du bateau : "+b.getType());
		System.out.print("Saisir les Coordonnées (x,y) du debut du bateau :\t");
		Point pDeb = new Point(sc.nextInt(), sc.nextInt());
		System.out.print("Saisir les Coordonnées (x,y) de fin du bateau :\t");
		Point pFin = new Point(sc.nextInt(), sc.nextInt());
		return new Bateau(pDeb, pFin, b.getType());
	}
	
	public static Point cibler(Grille g) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		boolean test = false;
		Point p;
		System.out.println("votre zone de tire : \n" + g);
		do { 
			if(test) System.out.println(" Tire impossible  !");
			System.out.print("Ou voulez vous tirer :\t");
			x = sc.nextInt();
			y = sc.nextInt();
			p = new Point(y,x);
			test = p.getX() < 0 || p.getX() > g.getLargeur()-1 || p.getY() < 0 || p.getY() > g.getLongueur()-1 || g.valeurCellule(p) != 0;
		}while(test);
		return p;
	}
	
	public static void affichage() {
		for(int i=0; i<40; i++) {
			System.out.println("");
		}
	}

}
