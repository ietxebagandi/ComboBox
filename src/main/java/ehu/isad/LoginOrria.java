package ehu.isad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


public class LoginOrria extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Flickr-en saioa hasi");
        Label label1 = new Label("Erabiltzailea: ");
        Label label2 = new Label("Pasahitza: ");

        TextField erabiltzailea = new TextField();
        PasswordField pasahitza = new PasswordField();

        Button button1 = new Button("Kautotu!");
        Button button2 = new Button("Irten");

        ComboBox cbHizkuntzak = new ComboBox();
        cbHizkuntzak.getItems().add("Euskara");
        cbHizkuntzak.getItems().add("Español");
        cbHizkuntzak.getItems().add("English");
        cbHizkuntzak.getSelectionModel().selectFirst();

        label1.setMinWidth(50);
        label1.setMinHeight(50);

        label2.setMinWidth(50);
        label2.setMinHeight(50);

        FileInputStream input = new FileInputStream("/home/aitor/Escritorio/ISAD/Flickr.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(60);
        imageView.setFitWidth(80);

        FileInputStream input2 = new FileInputStream("/home/aitor/Escritorio/ISAD/mendia.jpg");
        Image mendia = new Image(input2);
        BackgroundSize size = new BackgroundSize(375,325,true,true,true,false);
        BackgroundImage bg = new BackgroundImage(mendia, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,size);

        HBox hBoxIrudia = new HBox(imageView);
        hBoxIrudia.setAlignment(Pos.TOP_LEFT);

        VBox vBox1 = new VBox(label1,label2);
        VBox vBox2 = new VBox(erabiltzailea,pasahitza);
        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(35);

        HBox hBoxDatuak = new HBox(vBox1,vBox2);
        hBoxDatuak.setAlignment(Pos.CENTER);
        HBox hBoxBotoiak = new HBox(cbHizkuntzak,button1,button2);
        hBoxBotoiak.setAlignment(Pos.CENTER);
        hBoxBotoiak.setSpacing(40);

        VBox vBoxNagusia = new VBox(hBoxIrudia,hBoxDatuak,hBoxBotoiak);
        vBoxNagusia.setAlignment(Pos.CENTER);
        vBoxNagusia.setSpacing(40);


        Scene scene = new Scene(vBoxNagusia, 375,325);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
