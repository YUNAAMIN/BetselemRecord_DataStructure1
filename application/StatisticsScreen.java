package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class StatisticsScreen extends BorderPane {
	LocationList list;
	LocationList_Martry l;
	private int currentIndex;
	TextField age, name, location, date, avg, gender;
	int counter = 0;
	Double sum = 0.0;
	int counterM = 0;
	int counterF = 0;
	File file;

	public StatisticsScreen(LocationList list) throws Exception {
		this.list = list;
		BorderPane pane = new BorderPane();
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #F0E68C");
		Label welcomeLabel = new Label(" Statistics Screen...");
		welcomeLabel.setFont(new Font("Impact", 50));
		welcomeLabel.setTextFill(Color.web("#8B0000"));
		Image image = new Image("C:\\Users\\Yuna\\eclipse-workspace\\DataStructure_proj1\\search.gif");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);
		GridPane grid = new GridPane();
		age = new TextField();
		gender = new TextField();
		avg = new TextField();
		date = new TextField();
		Label mage = new Label("The numbers of martyrs by age:");
		Label mgender = new Label("The number of martyrs by gender:");
		Label avgm = new Label("The average age of martyrs:");
		Label mdate = new Label("The date that has the maximum number of martyrs:");
		mage.setFont(new Font("Comic Sans MS", 15));
		mgender.setFont(new Font("Comic Sans MS", 15));
		avgm.setFont(new Font("Comic Sans MS", 15));
		mdate.setFont(new Font("Comic Sans MS", 15));

		grid.setVgap(10);

		grid.add(mage, 0, 0);
		grid.add(age, 1, 0);
		grid.add(mgender, 0, 2);
		grid.add(gender, 1, 2);
		grid.add(avgm, 0, 3);
		grid.add(avg, 1, 3);
		grid.add(mdate, 0, 4);
		grid.add(date, 1, 4);
		// TextArea a = new TextArea();
		Button prev = new Button("Previous");
		prev.setFont(new Font("Comic Sans MS", 15));
		prev.setStyle("-fx-background-color: #CD853F");
		Button next = new Button("Next");
		next.setFont(new Font("Comic Sans MS", 15));
		next.setStyle("-fx-background-color: #CD853F");
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		HBox neprev = new HBox();
		neprev.setSpacing(20);
		neprev.setAlignment(Pos.CENTER);
		neprev.getChildren().addAll(prev, next);
		vbox.getChildren().addAll(imageView, welcomeLabel, neprev, grid, buttonBox);
		setCenter(vbox);
		setBottom(buttonBox);
		next.setOnAction(e -> {

			if (currentIndex < list.getSize() - 1) {

				// currentIndex++;
			}
		});

//			}
//
//		});
//		prev.setOnAction(event -> {
//			if (counter > 0) {
//				counter--;
//				setCurrentLocation(location.get(counter));
//				generateSummaryReport();
//			} else {
//				System.out.println("No previous location available.");
//			}
//		});
//
//		next.setOnAction(event -> {
//			if (counter < list.getSize() - 1) {
//				counter++;
//				setCurrentLocation(location.get(counter));
//				generateSummaryReport();
//			} else {
//				System.out.println("No next location available.");
//			}
//		});
	}

	private String updateTextField() throws Exception {
//		String city = list.get(list.getName());
//		System.out.println(city);
//		Node persons = list.search(city);
//		a.setText(persons.data.list_Martry.getAllMartyr());

		Object value = list.get(currentIndex);

		try {
			Scanner in = new Scanner(file);

			while (in.hasNext()) {
				String line = in.nextLine();
				String[] matryr = line.trim().split(",");
				String namee = matryr[0];
				String agee = matryr[1];
				String cityy = matryr[2];
				String datee = matryr[3];
				String genderr = matryr[4];
				if (genderr == "F" || genderr == "f")
					counterF++;
				else if (genderr == "M" || genderr == "m")
					counterM++;
				else
					line = in.nextLine();

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return counterF + " :" + counterM;
	}

//	public void generateSummaryReport() {
//		
//
//		LocationList martyrsLocation = getCurrentLocation();
//
//		int totalMartyrs = martyrsLocation.getSize();
//		if (totalMartyrs == 0) {
//			System.out.println("No martyrs found in the selected location.");
//			return;
//		}
//
//		System.out.println("Location: " + martyrsLocation.getName());
//
//		// 1. The numbers of martyrs by age
//		int[] martyrCountsByAge = new int[101];
//
//		Node current = martyrsLocation.getHead();
//		while (current != null) {
//			int age = current.getData(currentIndex);
//			martyrCountsByAge[age]++;
//			current = current.getNext();
//		}
//
//		System.out.println("Numbers of martyrs by age:");
//		for (int i = 0; i <= 100; i++) {
//			int count = martyrCountsByAge[i];
//			if (count > 0) {
//				System.out.println("Age: " + i + ", Count: " + count);
//			}
//		}
//		System.out.println();
//
//		// 2. The number of martyrs by gender
//		int maleCount = 0;
//		int femaleCount = 0;
//
//		current = martyrsLocation.getHead();
//		while (current != null) {
//			String gender = current.getMartyr().getGender();
//			if (gender.equalsIgnoreCase("Male")) {
//				maleCount++;
//			} else if (gender.equalsIgnoreCase("Female")) {
//				femaleCount++;
//			}
//			current = current.getNext();
//		}
//
//		System.out.println("Numbers of martyrs by gender:");
//		System.out.println("Male: " + maleCount);
//		System.out.println("Female: " + femaleCount);
//		System.out.println();
//
//		// 3. The average age of martyrs
//		int totalAge = 0;
//
//		current = martyrsLocation.getHead();
//		while (current != null) {
//			totalAge += current.getMartyr().getAge();
//			current = current.getNext();
//		}
//
//		double averageAge = (double) totalAge / totalMartyrs;
//		System.out.println("Average age of martyrs: " + averageAge);
//		System.out.println();
//
//		// 4. The date that has the maximum number of martyrs
//		int[] martyrCountsByDate = new int[31]; // Assuming date ranges from 1 to 31
//
//		current = martyrsLocation.getHead();
//		while (current != null) {
//			int date = Integer.parseInt(current.getMartyr().getDate().substring(8, 10));
//			martyrCountsByDate[date]++;
//			current = current.getNext();
//		}
//
//		int maxCount = 0;
//		int maxDate = 0;
//
//		for (int i = 1; i <= 31; i++) {
//			int count = martyrCountsByDate[i];
//			if (count > maxCount) {
//				maxCount = count;
//				maxDate = i;
//			}
//		}
//
//		System.out.println("Date with the maximum number of martyrs: " + maxDate);
//	}
}