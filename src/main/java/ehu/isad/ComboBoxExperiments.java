package ehu.isad;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Bidaiak");
        comboBox.getItems().add("Herri kirolak");
        comboBox.getItems().add("Kirolak");

        comboBox.setEditable(true);
        comboBox.setEditable(false);

        ListView listView = new ListView();

        ImageView imageView = new ImageView();



        comboBox.setOnAction(e -> {

            listView.getItems().clear();

            String bilduma = (String) comboBox.getValue();
            if (bilduma=="Bidaiak") {
                listView.getItems().add("Txina");
                listView.getItems().add("Senegal");
                listView.getItems().add("Paris");

            }
            if (bilduma=="Herri kirolak") {
                listView.getItems().add("Txingak");
                listView.getItems().add("Sokatira");
                listView.getItems().add("Zaldi-probak");


            }
            if (bilduma=="Kirolak") {
                listView.getItems().add("Saskibaloia");
                listView.getItems().add("Tenisa");
                listView.getItems().add("Golf");

            }

        });

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    String balioa = (String) observable.getValue();
                    if (balioa.equals("Txina")){
                        try {
                            imageView.setImage(lortuIrudia("txina.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Senegal")){
                        InputStream is = getClass().getResourceAsStream("/" + "senegal.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Paris")){
                        InputStream is = getClass().getResourceAsStream("/" + "paris.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Txingak")){
                        InputStream is = getClass().getResourceAsStream("/" + "txingak.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Sokatira")){
                        InputStream is = getClass().getResourceAsStream("/" + "sokatira.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Zaldi-probak")){
                        InputStream is = getClass().getResourceAsStream("/" + "zaldiprobak.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Saskibaloia")){
                        InputStream is = getClass().getResourceAsStream("/" + "saskibaloia.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Tenisa")){
                        InputStream is = getClass().getResourceAsStream("/" + "tenisa.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Golf")){
                        InputStream is = getClass().getResourceAsStream("/" + "golf.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }
                });




        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        HBox hbox = new HBox(comboBox,listView,imageView);
        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();



    };


    private Image lortuIrudia(String location) throws IOException {

        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
