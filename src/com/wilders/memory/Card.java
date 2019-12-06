package com.wilders.memory;

public class Card {

	String pic; // Bild der Karte
	Boolean visibility;
	Boolean hasCursor;

	// Constructor
	public Card(String pic, Boolean visibility) {
		this.pic = pic;
		this.visibility = visibility;
		this.hasCursor = false;
	}

	// Getters / Setters
	public String getPic() {
		return pic;
	}

	private void setPic(String pic) {
		this.pic = pic;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	private Boolean getHasCursor() {
		return hasCursor;
	}

	public void setHasCursor(Boolean cursor) {
		this.hasCursor = cursor;
	}

	public void showCard(int row) {
		if (this.hasCursor) {
			switch (row) {
			case 0:
				System.out.print("*******  ");
				break;
			case 1:
				System.out.print("*     *  ");
				break;
			case 2:
				if (this.getVisibility())
					System.out.print("*  " + this.getPic() + "  *  ");
				else
					System.out.print("*  " + "*" + "  *  ");
				break;
			case 3:
				System.out.print("*     *  ");
				break;
			case 4:
				System.out.print("*******  ");
				break;
			}
		} else {
			switch (row) {
			case 0:
				System.out.print("+-----+  ");
				break;
			case 1:
				System.out.print("|     |  ");
				break;
			case 2:
				if (this.getVisibility())
					System.out.print("|  " + this.getPic() + "  |  ");
				else
					System.out.print("*  " + "*" + "  *  ");
				break;
			case 3:
				System.out.print("|     |  ");
				break;
			case 4:
				System.out.print("+-----+  ");
				break;
			}
		}

	}

}
