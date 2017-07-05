package fr.pizzeria.console;

import java.util.Scanner;

/**
 * @author pc
 *
 */
public class PizzeriaAdminConsoleApp {
	static String[][] listePizza = new String[50][];

	/**
	 * Initialisation du tableau listePizza
	 */
	public static void initPizza() {

		listePizza[0] = new String[] { "0", "PEP", "Pépéroni", "12.50" };
		listePizza[1] = new String[] { "1", "MAR", "Margherita", "14.00" };
		listePizza[2] = new String[] { "2", "REI", "La reine", "11.50" };
		listePizza[3] = new String[] { "3", "FRO", "La 4 fromages", "12.00" };
		listePizza[4] = new String[] { "4", "CAN", "La cannibale", "12.50" };
		listePizza[5] = new String[] { "5", "SAV", "La savoyarde", "13.00" };
		listePizza[6] = new String[] { "6", "ORI", "L'orientale", "13.50" };
		listePizza[7] = new String[] { "7", "IND", "L'indienne", "14.00" };
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initPizza();

		int choixPizza = 0;
		do {

			System.out.println("***** Pizzeria Administration *****");

			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			Scanner choix = new Scanner(System.in);
			choixPizza = choix.nextInt();

			switch (choixPizza) {
			case 1:
				System.out.println("Liste des pizzas");
				listerLesPizza();
				break;
			case 2:
				System.out.println("Ajout d’une nouvelle pizza");
				ajoutPizza();
				break;
			case 3:
				System.out.println("Mise à jour d’une pizza");
				majPizza();
				break;
			case 4:
				System.out.println("Suppression d’une pizza");
				SupprPizza();
				break;
			default:
				System.out.println("Veuillez choisir un chiffre valide !");
				break;
			}
		} while (choixPizza != 99);
		System.out.println("Aurevoir :-(");
	}

	/**
	 * 
	 */
	public static void listerLesPizza() {
		for (int i = 0; i < listePizza.length; i++) {

			if (listePizza[i] != null && !listePizza[i][1].isEmpty()) {

				// for (int j = 0; j < listePizza[i].length; j++) {
				// System.out.print(listePizza[i][j] + " ");
				// }
				System.out.print(listePizza[i][1] + " -> " + listePizza[i][2] + " (" + listePizza[i][3] + ") ");

				System.out.println("");
			}
		}

		System.out.println("");
	}

	/**
	 * 
	 */
	public static void ajoutPizza() {

		System.out.println("Veuillez saisir le code");
		Scanner code = new Scanner(System.in);
		String codePizza = code.next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		Scanner nom = new Scanner(System.in);
		String nomPizza = nom.next();

		System.out.println("Veuillez saisir le prix");
		Scanner prix = new Scanner(System.in);
		String prixPizza = prix.next();

		for (int i = 0; i < listePizza.length; i++) {

			if (listePizza[i] == null) {

				listePizza[i] = new String[] { Integer.toString(i), codePizza, nomPizza, prixPizza };

				System.out.println("Pizza Ajouté !");
				System.out.println("");
				break;
			}
		}
	}

	

	/**
	 * 
	 */
	public static void SupprPizza() {
		listerLesPizza();
		System.out.println("Veuillez Choisir la pizza à supprimer");
		System.out.println("(99 pour abandonner)");
		Scanner code = new Scanner(System.in);
		String codePizza = code.next();

		for (int i = 0; i < listePizza.length; i++) {
			if (codePizza.equals(listePizza[i][1])) {
				listePizza[i] = new String[] {"","","",""};
				System.out.println("Pizza Supprimée !");
				break;
			}
		}

		System.out.println("");

	}
}
