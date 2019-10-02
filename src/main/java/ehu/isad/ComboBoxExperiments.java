package ehu.isad;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ComboBox comboBilduma = new ComboBox();
        List<String> bildumak = List.of("Bidaiak","Herri kirolak","Kirolak");
        ObservableList<Bilduma> bildumaList = FXCollections.observableArrayList();
        bildumak.forEach((elem)->{
            bildumaList.add(new Bilduma(elem));
        });
        comboBilduma.setItems(bildumaList);

        Map<String,List<Argazkia>> bildumaMap = new HashMap<>();
        bildumaMap.put("Bidaiak", List.of(new Argazkia("Txina","txina.jpg"),
                new Argazkia("Paris","paris.jpg"), new Argazkia("Senegal","senegal.jpg")));

        bildumaMap.put("Herri Kirolak", List.of(new Argazkia("Txingak","txingak.jpg"),
                new Argazkia("Sokatira","sokatira.jpg"), new Argazkia("Zaldi-probak","zaldiprobak.jpg")));

        bildumaMap.put("Kirolak", List.of(new Argazkia("Saskibaloia","saskibaloia.jpg"),
                new Argazkia("Tenisa","tenis.jpg"), new Argazkia("Golf","golf.jpg")));

        ObservableList<Argazkia> argazkiList = FXCollections.observableArrayList();
        argazkiList.addAll(bildumaMap.get("Bidaiak"));
        argazkiList.addAll(bildumaMap.get("Herri Kirolak"));
        argazkiList.addAll(bildumaMap.get("Kirolak"));

        comboBilduma.setEditable(false);

        ListView listViewOfArgazki = new ListView<>(argazkiList);

        ImageView imageView = new ImageView();

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener(  (observable, oldValue, newValue) -> {


            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getFitx();

            try {
                imageView.setImage(lortuIrudia(fitx /* 48x48 */));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });






        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        HBox hbox = new HBox(comboBilduma,listViewOfArgazki,imageView);
        Scene scene = new Scene(hbox, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();



    };


    private Image lortuIrudia(String location) throws IOException {

        System.out.println(getClass());
        System.out.println(location);
        InputStream is = getClass().getResourceAsStream("/" + location);
        BufferedImage reader = ImageIO.read(is);
        return SwingFXUtils.toFXImage(reader, null);

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
