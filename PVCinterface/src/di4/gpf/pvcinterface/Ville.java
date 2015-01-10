package di4.gpf.pvcinterface;

public class Ville {
	private int indice;
	private String nom;
	private float coordX;
	private float coordY;

	public Ville(int indice, String nom, float coordX, float coordY) {
		super();
		this.indice = indice;
		this.nom = nom;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public float getCoordX() {
		return coordX;
	}
	public void setCoordX(float coordX) {
		this.coordX = coordX;
	}
	public float getCoordY() {
		return coordY;
	}
	public void setCoordY(float coordY) {
		this.coordY = coordY;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
