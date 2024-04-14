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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sio.leo.projetconservatoire.modele.CrudConnexion;
import sio.leo.projetconservatoire.modele.DAO;

/**
 * FXML Controller class
 *
 * @author CAYUELA
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField tflogin;
    @FXML
    private PasswordField pfmdp;
    @FXML
    private Label erreurlabel;
     @FXML
    private Button btnConnexion;
     
     
    Connection cnx = DAO.getConnection();
    Statement smt = DAO.getStatement();
    
    CrudConnexion crudCnx = new CrudConnexion();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void validerConnexion() throws IOException, Exception{
        if(crudCnx.getMdp(tflogin.getText(), pfmdp.getText())){ 
            CrudConnexion.setLeEleve(crudCnx.requeteEleve(tflogin.getText())); 
            System.out.println("nom = " + CrudConnexion.getLeEleve().getNom() + ", prénom = " + CrudConnexion.getLeEleve().getPrenom() + ", id = " + CrudConnexion.getLeEleve().getId()); 
            // Changement de scene vers la page ConsommerTicket
            
            
        }
        else{
            erreurlabel.setText("Identifiant / Mot de passe incorrect"); //Message d'erreur si l'identifiant et le mdp ne sont pas identiques
        }
    }
    
}
