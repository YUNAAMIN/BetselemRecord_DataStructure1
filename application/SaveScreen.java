package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SaveScreen extends BorderPane {
	LocationList list;
	LocationList_Martry li;

	public SaveScreen(LocationList list) {
		this.list = list;
		BorderPane pane = new BorderPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #F0E68C");
		Label welcomeLabel = new Label("Save Screen...");
		welcomeLabel.setFont(new Font("Impact", 50));
		welcomeLabel.setTextFill(Color.web("#8B0000"));
		Label l = new Label("Export file to save :");
		l.setFont(new Font("Comic Sans MS", 15));
		TextField t = new TextField();
		HBox b = new HBox(10);
		b.setAlignment(Pos.CENTER);
		final Image labImage = new Image(
				"C:\\Users\\Yuna\\eclipse-workspace\\DataStructure_proj1\\src\\application\\images.png");

		ImageView labImageView = new ImageView(labImage);
		labImageView.setFitWidth(200);
		labImageView.setPreserveRatio(true);
		Button export = new Button("Export ");
		export.setFont(new Font("Comic Sans MS", 15));
		export.setStyle("-fx-background-color: #CD853F");
		b.getChildren().addAll(l, t, export);
		vbox.getChildren().addAll(labImageView, welcomeLabel, b);

		setCenter(vbox);

		export.setOnAction(e -> {
			String s = t.getText(), strLine = "";
			list.writeToFile(s);
			System.out.println("Data written to file successfully.");

		});
	}
}
