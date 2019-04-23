package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.Main;
import application.model.Building;
import application.model.Restroom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;


public class SelectionController {
	@FXML
	ComboBox<Button> buildingDropDown;
	@FXML
	ComboBox<Restroom> restroomDropDown;
	@FXML
	AnchorPane app;
	@FXML
	Button hover; 
	private ArrayList<String> buildings;
	private ArrayList<Restroom> restrooms;
	public void initialize() throws FileNotFoundException {
		File homeDir = new File("data");
		File image_home = new File ("image");
		for (File file : homeDir.listFiles() ) {
			if (file.isDirectory()) {
				Button button = new Button (file.getName());
				for (File f: image_home.listFiles()) {
					if ( file.getName().equalsIgnoreCase(f.getName().substring(0,f.getName().length()-4))) {
					Image image = new Image (f.toURI().toString());
					ImageView imageview = new ImageView (image);
					imageview.setFitHeight(250.0);
					imageview.setFitWidth(300.0);
					Tooltip tt = new Tooltip (); 
					tt.setGraphic(imageview);
					button.setTooltip(tt);
					button.setStyle("-fx-background-color: #333952");
					button.setFont(new Font("American Typewriter", 20));
					button.setTextFill(Color.web("#ffffff"));
					button.setMinWidth(buildingDropDown.getPrefWidth());
					buildingDropDown.getItems().add(button);
					}
				}
			}
		}
		buildingDropDown.setOnAction((event)->{
			System.out.println (buildingDropDown.getSelectionModel().getSelectedItem().getText());
			System.out.println ("Hello");
		});
	}
	public void hover (ActionEvent Event) {
		File home = new File ("image");
		Tooltip tt = new Tooltip();
		for (File file: home.listFiles()) {
			if (file.getName().equalsIgnoreCase("BB.jpg")) {
				System.out.println (file.toURI().toString());
				Image image = new Image (file.toURI().toString());
				ImageView imageview = new ImageView (image);
				imageview.setFitHeight(200.0);
				imageview.setFitWidth(250.0);
				tt.setGraphic(imageview);
			}
		}
		hover.setTooltip(tt);
	}
	/**
	 * Moves to Login.fxml
	 * @param event
	 */
	public void gotoLogin(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Moves to Reviews.fxml
	 * @param event The Go! button is pressed
	 */
	public void gotoReviews(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Reviews.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
