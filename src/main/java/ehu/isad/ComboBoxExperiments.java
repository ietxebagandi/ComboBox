package ehu.isad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Bidaiak");
        comboBox.getItems().add("Herri kirolak");
        comboBox.getItems().add("Saskibaloia");

        comboBox.setEditable(false);

        ListView listView = new ListView();

        ImageView imageView1 = new ImageView();

        comboBox.setOnAction(e -> {

            listView.getItems().clear();


            String bilduma = (String) comboBox.getValue();
            if (bilduma=="Bidaiak") {
                listView.getItems().add("1.1");
                listView.getItems().add("1.2");
                listView.getItems().add("1.3");
                try {
                    FileInputStream input = new FileInputStream("/home/aitor/Escritorio/ISAD/argazkia.jpg");
                    Image image = new Image(input);
                    imageView1.setImage(image);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
            if (bilduma=="Herri kirolak") {
                listView.getItems().add("2.1");
                listView.getItems().add("2.2");
                listView.getItems().add("2.3");

                try {
                    FileInputStream input = new FileInputStream("/home/aitor/Escritorio/ISAD/Alonsotegi Herri Kirolak 001.jpg");
                    Image image = new Image(input);
                    imageView1.setImage(image);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
            if (bilduma=="Saskibaloia") {
                listView.getItems().add("3.1");
                listView.getItems().add("3.2");
                listView.getItems().add("3.3");
                try {
                    FileInputStream input = new FileInputStream("/home/aitor/Escritorio/ISAD/Doncic.jpg");
                    Image image = new Image(input);
                    imageView1.setImage(image);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }





        });

        imageView1.setFitHeight(150);
        imageView1.setFitWidth(150);
        HBox hbox = new HBox(comboBox,listView,imageView1);
        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
