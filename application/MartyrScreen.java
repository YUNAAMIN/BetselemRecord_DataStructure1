package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MartyrScreen extends BorderPane {
	LocationList list;

	public MartyrScreen(LocationList list) {
		this.list = list;
		BorderPane pane = new BorderPane();
		GridPane grid = new GridPane();
		TextField name = new TextField();
		TextField age = new TextField();
		TextField location = new TextField();
		TextField date = new TextField();
		TextField gender = new TextField();
		Label lbAdded = new Label("enter number ");

		Label namel = new Label("Name:");
		Label agel = new Label("Age:");
		Label locationl = new Label("Location:");
		Label datel = new Label("Date:");
		Label genderl = new Label("Gender:");
		namel.setFont(new Font("Comic Sans MS", 15));
		agel.setFont(new Font("Comic Sans MS", 15));
		locationl.setFont(new Font("Comic Sans MS", 15));
		datel.setFont(new Font("Comic Sans MS", 15));
		genderl.setFont(new Font("Comic Sans MS", 15));
		grid.setVgap(10);

		grid.add(namel, 0, 0);
		grid.add(name, 1, 0);
		grid.add(agel, 0, 2);
		grid.add(age, 1, 2);
		grid.add(locationl, 0, 3);
		grid.add(location, 1, 3);
		grid.add(datel, 0, 4);
		grid.add(date, 1, 4);
		grid.add(genderl, 0, 5);
		grid.add(gender, 1, 5);

		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #F0E68C");
		final Image labImage = new Image(
				"C:\\Users\\Yuna\\eclipse-workspace\\DataStructure_proj1\\src\\application\\giphy.gif");

		ImageView labImageView = new ImageView(labImage);
		labImageView.setFitWidth(200);
		labImageView.setPreserveRatio(true);
		Label welcomeLabel = new Label("Matryr Screen...");
		welcomeLabel.setFont(new Font("Impact", 50));
		welcomeLabel.setTextFill(Color.web("#8B0000"));

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

		buttonBox.getChildren().addAll(insert, update, search);
		grid.setAlignment(Pos.CENTER);
		Label lbMsg = new Label();
		vbox.getChildren().addAll(labImageView, welcomeLabel, grid, lbMsg, buttonBox);

		setCenter(vbox);
		setBottom(buttonBox);
		insert.setOnAction(e -> {
			Node temp = list.search(location.getText());
			if (temp != null) {
				MartyrL obj = new MartyrL(location.getText());

				obj.list_Martry.insertSorted1(new MartyrD(name.getText(), age.getText(), location.getText(),
						date.getText(), gender.getText()));
				String agee = age.getText();
				if ((gender.getText().charAt(0) == 'M' || gender.getText().charAt(0) == 'F'
						|| gender.getText().charAt(0) == 'm' || gender.getText().charAt(0) == 'f')
						&& (agee.compareTo(100 + "") <= 0)) {
					list.insertSorted1(obj);
					lbMsg.setVisible(true);
					lbMsg.setText("has been successfully added");
				}
			} else {
				temp.data.list_Martry.insertSorted1(new MartyrD(name.getText(), age.getText(), location.getText(),
						date.getText(), gender.getText()));
				if ((gender.getText().charAt(0) != 'M' || gender.getText().charAt(0) != 'F'
						|| gender.getText().charAt(0) != 'm' || gender.getText().charAt(0) != 'f'))
				// && (agee.compareTo(100 + "") >= 0)) {
				{
					lbMsg.setVisible(true);
					lbMsg.setText("check out ur data there is sth wrong in information!!!!");
					System.out.println("check out ur data there is sth wrong in information!!!!");
				}
			}

			lbMsg.setVisible(true);
			lbMsg.setText("has been successfully added");
		});
		update.setOnAction(e ->

		{
			Node temp = list.search(location.getText());
			if (temp == null) {
				MartyrL obj = new MartyrL(location.getText());

				obj.list_Martry.removeNode(temp);
				int agee = Integer.parseInt(age.getText());
				if ((gender.getText().charAt(0) == 'M' || gender.getText().charAt(0) == 'F'
						|| gender.getText().charAt(0) == 'm' || gender.getText().charAt(0) == 'f') && (agee <= 100)) {
					list.removeNode(obj);
					lbMsg.setVisible(true);
					lbMsg.setText("has been successfully deleated");
				}
			} else {
				temp.data.list_Martry.removeNode(temp);
				lbMsg.setVisible(true);
				lbMsg.setText("check out ur data there is sth wrong in information!!!!");
				System.out.println("check out ur data there is sth wrong in information!!!!");
			}

			lbMsg.setText("ERROR: Out of bound exception");

		});

		search.setOnAction(e -> {

			String n = name.getText();
			MartyrD person = list.searchByName(n);
			age.setText(person.getAge());
			location.setText(person.getLocation());
			date.setText(person.getDate());
			gender.setText(person.getGender());

		});

	}

}
