package edu.nd.se2018.homework.ChipsChallenge;

public class Chip {
	int x, y;
	String imagePath;
	boolean[][] levelGrid;
	
	public Chip(int x, int y, boolean[][] levelGrid) {
		this.x = x;
		this.y = y;
		imagePath = "images\\chipUp.png";
		this.levelGrid = levelGrid;
	}
	
	public void goUp() {
		if (y >0 && levelGrid[x][y-1]==false) {
			y-=1;
			imagePath = "images\\chipUp.png";
		}
	}
	public void goDown() {
		if (y <24 && levelGrid[x][y+1]==false ) {
			y+=1;
			imagePath = "images\\chipDown.png";
		}
	}
	public void goRight() {
		if (x <24 && levelGrid[x+1][y]==false) {
			x+=1;
			imagePath = "images\\chipRight.png";
		}
	}
	public void goLeft() {
		if (x >0 && levelGrid[x-1][y]==false) {
			x-=1;
			imagePath = "images\\chipLeft.png";
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getImagePath() {
		return imagePath;
	}
}
