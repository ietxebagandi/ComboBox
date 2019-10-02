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
                        try {
                            imageView.setImage(lortuIrudia("senegal.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Paris")){
                        try {
                            imageView.setImage(lortuIrudia("paris.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Txingak")){
                        try {
                            imageView.setImage(lortuIrudia("txingak.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Sokatira")){
                        try {
                            imageView.setImage(lortuIrudia("sokatira.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Zaldi-probak")){
                        try {
                            imageView.setImage(lortuIrudia("zaldiprobak.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Saskibaloia")){
                        InputStream is = getClass().getResourceAsStream("/" + "saskibaloia.jpg");
                        Image image = new Image(is);
                        imageView.setImage(image);
                    }

                    if (balioa.equals("Tenisa")){
                        try {
                            imageView.setImage(lortuIrudia("tenisa.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (balioa.equals("Golf")){
                        try {
                            imageView.setImage(lortuIrudia("golf.jpg"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

        System.out.println(getClass());
        System.out.println(location);
        InputStream is = getClass().getResourceAsStream(location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
