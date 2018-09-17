import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	boolean[][] oceanGrid = new boolean[25][25];
	final int dimensions = 25;
	public void drawMap(ObservableList<Node> root, int scale) {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = false;
			}
		}
		placeIslands(root, scale);
	}
	
	public void placeIslands(ObservableList<Node> root, int scale) {
		Random rand = new Random();
		for (int i=0;i<10; i++) {
			int x = rand.nextInt(25);
			int y = rand.nextInt(25);
			Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREEN);
			root.add(rect);
			oceanGrid[x][y] = true;
		}
	}
	
}
