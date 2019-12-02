package com.wilders.memory;

public class Cursor {
	
	int XPos; //X-Achsenposition
	int YPos; //Y-Achsenposition

	public Cursor(int x, int y) {
		this.XPos = x;
		this.YPos = y;
	}

	public Cursor() {
		this.XPos = 0;
		this.YPos = 0;
	}
	
	
	//Getters/Setters
	private int getXPos() {
		return XPos;
	}

	private void setXPos(int xPos) {
		XPos = xPos;
	}

	private int getYPos() {
		return YPos;
	}

	private void setYPos(int yPos) {
		YPos = yPos;
	}

	public void SetCursor (int x,int y) {
	this.XPos = x;
	this.YPos = y;
	}

}
