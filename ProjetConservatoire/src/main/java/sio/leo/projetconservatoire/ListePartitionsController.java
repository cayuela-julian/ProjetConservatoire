/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sio.leo.projetconservatoire;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sio.leo.projetconservatoire.modele.CrudConnexion;
import sio.leo.projetconservatoire.modele.DAO;

/**
 * FXML Controller class
 *
 * @author CAYUELA
 */
public class ListePartitionsController implements Initializable {
    
    private static Connection cnx = DAO.getConnection();
    //pour exécuter des requêtes
    private static Statement smt= DAO.getStatement();
    private ResultSet rs =null;
    private String requete2 ="";

    @FXML
    private TableView<Partition> tablePartition;
    @FXML
    private TableColumn<Partition, String> NomColumn;
    @FXML
    private TableColumn<Partition, String> AuteurColumn;
    @FXML
    private TableColumn<Partition, Number> IdColumn;
    @FXML
    private TextField tfPage;
    @FXML
    private Button btnMoove;
    @FXML
    private Button btnSaisie;
    
    
    ObservableList<Partition> liste = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     * 
     */
    
    //Initialisation du teableau avec la liste des partitions
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IdColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        NomColumn.setCellValueFactory(cellData -> cellData.getValue().getNomPartition());
        AuteurColumn.setCellValueFactory(cellData -> cellData.getValue().getAuteur());
        String requete = "Select * from PARTITIONS;";
        try {
            rs = smt.executeQuery(requete);
            
            while(rs.next()){
                Integer id = rs.getInt("PARNUM");
                String nom = rs.getString("PARNOM");
                String auteur = rs.getString("PARAUTEUR");
                liste.add(new Partition(id,nom,auteur));
            }
            tablePartition.setItems(liste);
          
           
            } catch (SQLException ex) {
            System.out.println("erreur");
        }
            
        
    //Fonction qui met la partition dans le classeur
    }
    public void mooveToClasseur(){
        requete2 = "";
        try {
            int page = Integer.parseInt(tfPage.getText());
            Partition p = (Partition)tablePartition.getSelectionModel().getSelectedItem();
            requete2 = "INSERT INTO PARTITIONELEVE VALUES("+CrudConnexion.getLeEleve().getId()+", "+p.getIdentifiant()+", "+page+");";
        }
            catch(NumberFormatException e){
            System.out.println("erreur chiffre");
        }
         try {
                smt.execute(requete2);  
                System.out.println(CrudConnexion.getLeEleve().getId());
           
        }
            catch(SQLException e){
                System.out.println(e);
            }
        
    }
    
  
}
        
        

