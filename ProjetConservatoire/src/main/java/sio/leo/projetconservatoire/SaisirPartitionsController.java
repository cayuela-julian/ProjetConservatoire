/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sio.leo.projetconservatoire;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sio.leo.projetconservatoire.modele.DAO;

/**
 * FXML Controller class
 *
 * @author CAYUELA
 */
public class SaisirPartitionsController implements Initializable {
    @FXML
    private TextField tfNomPart;
    @FXML
    private TextField tfAutPart;
    
    private static Connection cnx = DAO.getConnection();
    //pour exécuter des requêtes
    private static Statement smt= DAO.getStatement();
    
    private ResultSet rs =null;
    
    private String requete2 ="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void addToPartitions() throws SQLException{
        requete2 ="";
        String nom = tfNomPart.getText();
        String auteur= tfAutPart.getText();
        requete2="INSERT INTO PARTITIONS VALUES("+DAO.getIntValable()+", ?, ?);";
        try{
            PreparedStatement preparedStatement = cnx.prepareStatement(requete2, ResultSet.TYPE_SCROLL_INSENSITIVE);{
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, auteur);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

    }
    
}
