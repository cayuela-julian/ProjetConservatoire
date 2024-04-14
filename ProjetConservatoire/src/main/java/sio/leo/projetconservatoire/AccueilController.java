/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sio.leo.projetconservatoire;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sio.leo.projetconservatoire.modele.CrudConnexion;
import sio.leo.projetconservatoire.modele.DAO;

/**
 * FXML Controller class
 *
 * @author CAYUELA
 */
public class AccueilController implements Initializable {
    
    @FXML 
    private Button btnSaisir;
    @FXML
    private Button btnRechercher;
    
    @FXML
    private BorderPane border;
    @FXML
    private AnchorPane anchordroite;

    /**
     * Initializes the controller class.
     */
    Connection cnx = DAO.getConnection();
    Statement smt = DAO.getStatement();
    
    CrudConnexion crudCnx = new CrudConnexion();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
   
    
   private void loadFXML(URL url){
       try{
           FXMLLoader loader = new FXMLLoader(url);
           border.setCenter(loader.load());
           
       }
       catch (IOException e){
           
       }
   }
    
    
    public void afficherVue(ActionEvent click){
        String vue = (String) ((Node)click.getSource()).getUserData();
        
        loadFXML(getClass().getResource(vue));

    }
}
