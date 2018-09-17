import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class OceanExplorer extends Application {
	AnchorPane root;
	int scalingFactor = 30;
	OceanMap oceanMap;
	Scene scene;
	ImageView shipImageView,pirate1ImageView, pirate2ImageView;
	Ship ship;
	PirateShip pirate1, pirate2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage oceanStage) throws Exception{
		oceanMap = new OceanMap();
		
		
		root = new AnchorPane();
		oceanMap.drawMap(root.getChildren(), scalingFactor);
		
		ship = new Ship(oceanMap);
		Image shipImage = new Image(new FileInputStream(".\\src\\ColumbusShip.png"),30,30,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x*scalingFactor);
		shipImageView.setY(ship.getShipLocation().y*scalingFactor);
		root.getChildren().add(shipImageView);
		
		pirate1 = new PirateShip(oceanMap);
		Image pirateImage1 = new Image(new FileInputStream(".\\src\\pirateship.gif"),30,30,true,true);
		pirate1ImageView = new ImageView(pirateImage1);
		pirate1ImageView.setX(pirate1.getpShipLocation().x*scalingFactor);
		pirate1ImageView.setY(pirate1.getpShipLocation().y*scalingFactor);
		root.getChildren().add(pirate1ImageView);
		
		pirate2 = new PirateShip(oceanMap);
		Image pirateImage2 = new Image(new FileInputStream(".\\src\\pirateship.gif"),30,30,true,true);
		pirate2ImageView = new ImageView(pirateImage2);
		pirate2ImageView.setX(pirate2.getpShipLocation().x*scalingFactor);
		pirate2ImageView.setY(pirate2.getpShipLocation().y*scalingFactor);
		root.getChildren().add(pirate2ImageView);
		
		scene = new Scene(root,750,750);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus Sailing");
		oceanStage.show();
		
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);
		
		startSailing();
		
	}
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
				pirate1ImageView.setX(pirate1.getpShipLocation().x*scalingFactor);
				pirate1ImageView.setY(pirate1.getpShipLocation().y*scalingFactor);
				pirate2ImageView.setX(pirate2.getpShipLocation().x*scalingFactor);
				pirate2ImageView.setY(pirate2.getpShipLocation().y*scalingFactor);
			}
		});
	}
}
