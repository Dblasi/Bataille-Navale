import java.util.Scanner;

public class Point {
	private int x;
	private int y;
	
	public Point (int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)) return false;
		Point temp = (Point) o;
		return	this.getX() == temp.getX() && this.getY() == temp.getY();
	}
	
	public boolean inSegment (Point a, Point b) {
		// Si le test est sur l'axe horizontal
		if(a.getY() == b.getY() && this.getX() == a.getY())
			return (this.getY() <= b.getX() && this.getY() >= a.getX()) || (this.getY() >= b.getX() && this.getY() <= a.getX());
		// Si le test est sur l'axe verticale
		else if(a.getX() == b.getX() && this.getY() == a.getX()) 
			return (this.getX() <= b.getY() && this.getX() >= a.getY()) || (this.getX() >= b.getY() && this.getX() <= a.getY());
		// Sinon balec !!!
		else return false;		
	}
	
	public static int tailleSegment(Point a, Point b) {
		return (int)Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2)) + 1;
	}
	
	@Override
	public String toString() {
		return this.getX()+";"+this.getY();
	}
}
