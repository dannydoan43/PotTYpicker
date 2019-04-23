package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author Kevin Nguyen (zpp390)
 *
 * 
 */
public class MapController  {
	@FXML
	WebView myWeb; 
	@FXML
	AnchorPane father; 
	public void initialize() {
		// TODO Auto-generated method stub
		StackPane  root = new StackPane ();
		WebView web = new WebView (); 
		WebEngine engine = web.getEngine();
		System.out.println ("Hello There");
		engine.load("https://www.google.com");
		root.getChildren().add(web);
		father.getChildren().add(root);
	}
}