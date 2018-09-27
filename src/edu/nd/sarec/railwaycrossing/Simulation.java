package edu.nd.sarec.railwaycrossing;

import java.util.ArrayList;
import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.MapBuilder;
import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import edu.nd.sarec.railwaycrossing.model.vehicles.Train;
import edu.nd.sarec.railwaycrossing.view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
				
		// Train
		RailwayTracks track = mapBuilder.getTrack("Royal");
		Train train = new Train(track.getEndX()+100,track.getEndY()-25,0);
		root.getChildren().add(train.getImageView());
		
		// Train 2
		RailwayTracks track2 = mapBuilder.getTrack("Jubilee");
		Train train2 = new Train(track2.getStartX()-100,track2.getEndY()-25,1);
		root.getChildren().add(train2.getImageView());
		
		for(CrossingGate gate: mapBuilder.getAllGates()) {
			train.addObserver(gate);
			train2.addObserver(gate);
		}
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				train.move();
				train2.move();
				
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				if (train.offScreen())
					train.reset();
				if (train2.offScreen())
					train2.reset();
				
				clearCars();				
			}
		}.start();
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
			}
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 100) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	private void moveCarsToEast() {
		Road road1 = mapBuilder.getRoadsWithName().get("Western Highway");
		Road road2 = mapBuilder.getRoadsWithName().get("EastWest");
		ArrayList<Car> cars1 = road1.getCars();
		ArrayList<Car> cars2 = road2.getCars();
		Car changingCar;
		for (int i=0; i< cars1.size(); i++) {
			if (cars1.get(i).getVehicleY() == 800) {
				changingCar = cars1.get(i);
				if (i+1<cars1.size())
					cars1.get(i).deleteObserver(cars1.get(i+1));
				if (i>0) {
					cars1.get(i-1).deleteObserver(cars1.get(i));
					cars1.get(i-1).addObserver(cars1.get(i+1));
				}
				cars1.remove(i);
				//need to set changingCar coordinates to the beginning of road 2.
				cars2.add(changingCar);
				break;
			}
		}
		
	}
	
	private void addCarsFromEast() {
		Road road1 = mapBuilder.getRoadsWithName().get("EastWest");
		Road road2 = mapBuilder.getRoadsWithName().get("Skyway");
		ArrayList<Car> cars1 = road1.getCars();
		ArrayList<Car> cars2 = road2.getCars();
		for (Car car : cars1) {
			if(car.getVehicleX()<=420) {
				
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

