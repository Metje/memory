package com.wilders.memory;

public class Cursor {
	
	int XPos; //X-Achsenposition
	int YPos; //Y-Achsenposition
	int dim = 4;

	public Cursor(int x, int y, int dim) {
		this.XPos = x;
		this.YPos = y;
		this.dim = dim;
	}

	public Cursor() {
		this.XPos = 0;
		this.YPos = 0;
		this.dim = 0;
	}
	
	
	//Getters/Setters
	public int getXPos() {
		return XPos;
	}

	private void setXPos(int xPos) {
		XPos = xPos;
	}

	public int getYPos() {
		return YPos;
	}

	private void setYPos(int yPos) {
		YPos = yPos;
	}

	public void SetCursor (int x,int y) {
	this.XPos = x;
	this.YPos = y;
	}
	
		
	public void SetCursorLeft () {
		if (this.getXPos()>0)
			this.XPos -= 1;
		else
			this.XPos = 0;
		}
	
	public void SetCursorRight () {
		if (this.getXPos()<dim-1)
			this.XPos += 1;
		else
			this.XPos = dim-1;
		}
	
	public void SetCursorUp () {
		if (this.getYPos()>0)
			this.YPos -= 1;
		else
			this.YPos = 0;
		}
	
	public void SetCursorDown () {
		if (this.getYPos()<dim-1)
			this.YPos += 1;
		else
			this.YPos = dim-1;
		}

}
