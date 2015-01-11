package di4.gpf.pvcinterface;

import java.util.Iterator;
import java.util.Stack;

public class Solution {
	private Stack<Ville> chemin;
	private double score;
	private long chronoStrt;

	public Solution() {
		super();
		start();
	}

	public double dist(Ville vA, Ville vB) {
		return Math.sqrt(Math.hypot(vA.getCoordX(), vB.getCoordY()));
	}

	public void addNext(Ville ville) {
		chemin.push(ville);
	}

	public Ville delLast() {
		return chemin.pop();
	}

	public void start() {
		chronoStrt = System.nanoTime();
	}

	public void opt2() {
		int taille = chemin.size();
		int i = 0, j = 0;
		Boolean mod = true;
		Ville vi1, vj1, vi2, vj2;
		while (mod) {
			mod = false;
			for (i = 0; i < taille; i++) {
				for (j = 0; j < taille; j++) {
					if (j != i - 1 && j != i && j != i + 1) {
						vi1 = chemin.get(i);
						vi2 = chemin.get(i + 1);
						vj1 = chemin.get(j);
						vj2 = chemin.get(j + 1);
						if (dist(vi1, vi2) + dist(vj1, vj2) > dist(vi1, vj1)
								+ dist(vi2, vj1)) {
							chemin.set(i + 1, vj1);
							chemin.set(j, vi2);
							mod = true;
						}
					}
				}
			}
		}

	}

}
