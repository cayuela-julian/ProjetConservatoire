package sio.leo.projetconservatoire;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import sio.leo.projetconservatoire.modele.DAO;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
     private static Connection cnx = null;
    //pour exécuter des requêtes
    private static Statement smt=null;

    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Accueil"), 660, 480);
        stage.setScene(scene);
        stage.show();
        cnx = DAO.getConnection();
        
        smt = DAO.getStatement();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    

}