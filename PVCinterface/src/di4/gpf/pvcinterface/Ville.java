package di4.gpf.pvcinterface;

public class Ville {
	private int indice;
	private String nom;
	private double coordX;
	private double coordY;


	public Ville(int indice) {
		super();
		this.indice = indice;
	}
	
	public Ville(int indice, String nom, double coordX, double coordY) {
		super();
		this.indice = indice;
		this.nom = nom;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	

	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	public double getCoordY() {
		return coordY;
	}
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
