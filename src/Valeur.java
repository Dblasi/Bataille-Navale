
public enum Valeur {
	vide(0),
	tire(1),
	touche(2),
	coule(3),
	bateau(7);
	
	private int valeur;
	public int getValeur() {
		return valeur;
	}
	
	private Valeur(int valeur) {
		this.valeur = valeur;
	}
	
	@Override
	public String toString() {
		return valeur +"";
	}
}
