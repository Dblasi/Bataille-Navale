import java.util.ArrayList;
import java.util.List;

public class Bateau {
	
	private Point coorDebut;
	private Point coorFin;
	private int ptVie;
	private TypeBateau type;
	
	public Bateau (TypeBateau type) {
		this.type=type;
	}
	
	public Bateau(Point A, Point B, TypeBateau type) throws Exception{
		this(type);
		Point deb, fin;
		if(A.getX() > B.getX() || A.getY() > B.getY()){
			deb = B;
			fin = A;
		}else {
			deb = A;
			fin = B;
		}
		if(Point.tailleSegment(deb, fin) != type.getTaille())
			throw new Exception("Coordonnées du bateau invalide");
		this.coorDebut = deb;
		this.coorFin = fin;
		this.setPtVie(type.getTaille());
	}
	
	public void setCoorDebut(Point coorDebut ) {
		this.coorDebut = coorDebut;	
	}
	
	public void setCoorFin(Point coorFin ) {
		this.coorFin = coorFin;	
	}
	
	public Point getCoorDebut() {
		return this.coorDebut;
	}
	
	public Point getCoorFin() {
		return this.coorFin;
	}
	
	
	public TypeBateau getType() {
		return type;
	}

	public void setType(TypeBateau type) {
		this.type = type;
	}
	
	public int getPtVie() {
		return ptVie;
	}

	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}

	public List<Point> getPoints(){
		List<Point> points = new ArrayList<>();
		for(int y = this.getCoorDebut().getY(); y <= this.getCoorFin().getY(); y++)
			for(int x = this.getCoorDebut().getX(); x <= this.getCoorFin().getX(); x++)
				points.add(new Point(y, x));
		return points;
	}
	
	@Override
	public String toString() {
		return type +" "+ getCoorDebut() + "-" + getCoorFin() ;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Bateau)) return false;
		Bateau b = (Bateau)o;
		return this.type.equals(b.type) && this.getCoorDebut().equals(b.getCoorDebut()) && this.getCoorFin().equals(b.getCoorFin());
	}
	
}

