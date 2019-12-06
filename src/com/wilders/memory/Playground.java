package com.wilders.memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Playground {
	static int dim = 4;
	static Scanner s = new Scanner(System.in);

	public Playground() throws InterruptedException {

		final int dim = 4;
		Card[][] aPlayground = new Card[dim][dim];

		// Liste von Karten erzeugen und mischen
		List<Card> lCard = new ArrayList<Card>();
		for (int i = 0; i < 2; i++) {
			lCard.add(new Card("\u2666", false));
			lCard.add(new Card("\u2665", false));
			lCard.add(new Card("\u2660", false));
			lCard.add(new Card("\u2663", false));
			lCard.add(new Card("A", false));
			lCard.add(new Card("B", false));
			lCard.add(new Card("C", false));
			lCard.add(new Card("D", false));
		}
		Collections.shuffle(lCard);

		// Array befüllen
		for (int x = 0; x < dim; x++)
			for (int y = 0; y < dim; y++) {
				aPlayground[x][y] = lCard.get(x * dim + y);
			}

		// Cursor setzen Start (0/0)
		Cursor cursor = new Cursor(0, 0, dim);
		// Setze CursorInformation in den Karten des Playgrounds
		setCursorInfo(aPlayground, cursor);

		// Spielfeld ausgeben
		for (int i = 0; i < dim; i++)
			ausgebenReihe(i, aPlayground);

		boolean end = false;
		Card card1 = null;
		Card card2 = null;
		int tried = 0;
		while (!end) {
			System.out.println("Bitte bewegen sie den Cursor mit A=" + "\u2190" + ", W=" + "\u2191" + ", S=" + "\u2192"
					+ ", Y=" + "\u2193");
			System.out.println("Wenn sie die Karte umdrehen möchten dann geben Sie ein 'D' ein");
			System.out.println("Wenn sie aufhören möchten dann geben Sie ein 'E' ein");
			char ch = s.next().charAt(0);
			if ((ch == 'E') || (ch == 'e'))
				end = true;
			if ((ch == 'A') || (ch == 'a')) {
				// Cursor nach links
				cursor.SetCursorLeft();
			}
			if ((ch == 'W') || (ch == 'w')) {
				// Cursor nach oben
				cursor.SetCursorUp();
			}
			if ((ch == 'S') || (ch == 's')) {
				// Cursor nach rechts
				cursor.SetCursorRight();
			}
			if ((ch == 'Y') || (ch == 'y')) {
				// Cursor nach unten
				cursor.SetCursorDown();
			}
			if ((ch == 'D') || (ch == 'd')) {
				// umdrehen -> Visibility der Karte umsetzen
				if (aPlayground[cursor.getXPos()][cursor.getYPos()].getVisibility() == false) {
					// nur, wenn noch nicht umgedreht
					if (card1 == null) {
						card1 = aPlayground[cursor.getXPos()][cursor.getYPos()];
						card1.setVisibility(true);
					} else {
						card2 = aPlayground[cursor.getXPos()][cursor.getYPos()];
						card2.setVisibility(true);
						tried++;
						if (card1.getPic().equals(card2.getPic())) {
							// Beide Karten sind gleich

						} else {
							// Beide Karten sind verschieden erst zeigen, dann wieder umdrehen
							// Zeigen
							for (int i = 0; i < dim; i++)
								ausgebenReihe(i, aPlayground);
							System.out.println("Das war nix");
							Thread.sleep(2000);

							card1.setVisibility(false);
							card2.setVisibility(false);
						}
						card1 = null;
						card2 = null;
					}
				}

			}

			setCursorInfo(aPlayground, cursor);

			// Spielfeld ausgeben
			for (int i = 0; i < dim; i++)
				ausgebenReihe(i, aPlayground);
			if (getAnzVisibleCards(aPlayground) == (dim * dim)) {
				System.out.println("!!!!!! FERTIG !!!!!!");
				System.out.println("Du hast " + tried + " Versuche benötigt!");
				end = true;
			}

		}

	}

	private static void setCursorInfo(Card[][] aPlayground, Cursor cursor) {
		for (int x = 0; x < dim; x++)
			for (int y = 0; y < dim; y++) {
				if ((x == cursor.getXPos()) && (y == cursor.getYPos()))
					aPlayground[x][y].setHasCursor(true);
				else
					aPlayground[x][y].setHasCursor(false);
			}
	}

	private static void ausgebenReihe(int y, Card[][] aPlayground) {
		// Mitte
		for (int reihe = 0; reihe < 5; reihe++) {
			for (int x = 0; x < dim; x++) {
				// Spalte x
				aPlayground[x][y].showCard(reihe);
			}
			System.out.println();
		}
	}

	private static int getAnzVisibleCards(Card[][] aPlayground) {
		// Anzahl sichtbare Karten
		int count = 0;
		for (int x = 0; x < dim; x++)
			for (int y = 0; y < dim; y++) {
				// Spalte x
				if (aPlayground[x][y].getVisibility())
					count++;
			}
		return count;
	}

}
