
public enum TypeBateau {
	porte_avions (5),
	croiseur(4),
	contre_torpilleur(3),
	sous_marin(3),
	torpilleur(2),
	cuirasse(4);
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	private int taille;
	private TypeBateau(int Taille) {
		
		taille=Taille;
		
	}
	
	@Override
	public String toString() {
		return this.name()+"("+this.getTaille()+")";
	}
}
