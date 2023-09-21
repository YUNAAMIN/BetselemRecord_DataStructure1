package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LocationScreen extends BorderPane {
	LocationList list = Main.list;

	public LocationScreen(LocationList list) {
		this.list = list;
		BorderPane pane = new BorderPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #F0E68C");
		Label welcomeLabel = new Label("Location Screen...");
		welcomeLabel.setFont(new Font("Impact", 50));
		welcomeLabel.setTextFill(Color.web("#8B0000"));
		Label l = new Label("Location :");
		l.setFont(new Font("Comic Sans MS", 15));
		TextField t = new TextField();
		HBox b = new HBox(10);
		b.getChildren().addAll(l, t);
		b.setAlignment(Pos.CENTER);
		Image image = new Image(
				"C:\\Users\\Yuna\\eclipse-workspace\\DataStructure_proj1\\src\\application\\image_processing20191230-31370-1w5tizz.gif");

		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);
		TextArea a = new TextArea();
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		Button insert = new Button("Insert ");
		insert.setFont(new Font("Comic Sans MS", 15));
		insert.setStyle("-fx-background-color: #CD853F");
		Button search = new Button("Search ");
		search.setFont(new Font("Comic Sans MS", 15));
		search.setStyle("-fx-background-color: #CD853F");
		Button update = new Button("Delete");
		update.setFont(new Font("Comic Sans MS", 15));
		update.setStyle("-fx-background-color: #CD853F");
		Label lbMsg = new Label("");
		lbMsg.setTextFill(Color.RED);
		lbMsg.setFont(new Font(20));

		buttonBox.getChildren().addAll(insert, update, search);
		vbox.getChildren().addAll(imageView, welcomeLabel, b, lbMsg, a, buttonBox);

		setCenter(vbox);
		setBottom(buttonBox);

		search.setOnAction(e -> {
			String city = t.getText();
			System.out.println(city);
			Node persons = list.search(city);
			a.setText(persons.data.list_Martry.getAllMartyr());

		});

		update.setOnAction(e -> {
			String city = t.getText();
			System.out.println(city);
			Node persons = list.search(city);
			persons.data.list_Martry.removeAll();
			a.setText("The " + city + " that u have choose is deleted sucssefully!!!!");
		});

		insert.setOnAction(e -> {
			String city = t.getText();
			System.out.println(city);
			Node persons = list.search(city);
			MartyrL ls = new MartyrL(city);
			if (persons == null)
				list.insertNode(ls);
			a.setText(city + " addad to the DoublyLinkedList succssesfully!!!!!!!11");
		});
	}
}
