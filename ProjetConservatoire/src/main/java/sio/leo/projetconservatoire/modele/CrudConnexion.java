/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.projetconservatoire.modele;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import sio.leo.projetconservatoire.modele.DAO;
import sio.leo.projetconservatoire.Eleve;

/**
 *
 * Classe qui initialise la connexion à la BDD ainsi que les méthodes utilisées dans notre controller pour que la connexion remplisse des conditions
 * 
 * @author CAYUELA
 */
public class CrudConnexion {
    //Initialisation de la connexion au DAO
  private static final Connection cnx=DAO.getConnection();
    
    private static final Statement smt =DAO.getStatement();
    
    private static Eleve leEleve;
    
    //Déclaration du resultSet
    private ResultSet rs =null;
    
    
     public Boolean idExist(String id) throws SQLException, SQLIntegrityConstraintViolationException{
        String requete = "SELECT ELELOGIN FROM ELEVE WHERE ELELOGIN ='"+id+"';";
        this.rs = smt.executeQuery(requete);
        while(rs.next()){
            String idAll  = rs.getString("ELELOGIN");
            if(idAll.equals(id)){
                return true;
            }
        }   
        return false;
    }
      public Boolean getMdp(String id, String mdp) throws IOException, SQLException, SQLIntegrityConstraintViolationException, Exception{ 
        try{
            if(!id.isEmpty() && !mdp.isEmpty()){
                if(idExist(id)){
                    String requete = "SELECT ELEMDP FROM ELEVE WHERE ELELOGIN = ? AND ELEMDP = PASSWORD(?)"; //Selectione le mdp et l'id dans la base
                    PreparedStatement preparedStatement = cnx.prepareStatement(requete, ResultSet.TYPE_SCROLL_INSENSITIVE); // execute la requête ci-dessus
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, mdp);
                    System.out.println(mdp);
                    this.rs = preparedStatement.executeQuery();
                    if(rs.next()){
                        String mdpCrypt  = rs.getString("ELEMDP"); //Crypte le mdp et vérifie s'il est le même que celui crypter dans la BDD
                        System.out.println(mdpCrypt);

                        return true;
                        }
                        return false; // Si la boucle ne trouve pas de correspondance
                    } 
                else {
                    return false; // Si id n'existe pas
                }
            } 
            else {
                return false; // Si id ou mdp sont vides
            }
        } catch (NumberFormatException e) {
            return false; // Gestion spécifique si une exception de format numérique se produit
        }
    }
      public Eleve requeteEleve(String id) 
    {
        try
        {
            
            String query = "Select * from ELEVE where ELELOGIN = ?;";
            PreparedStatement preparedStatement = cnx.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE);
            preparedStatement.setString(1, id);   
            this.rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                Integer num = rs.getInt("ELENUM");
                String nom=rs.getString("ELENOM");
                String prenom=rs.getString("ELEPRENOM");
                Integer cycle = rs.getInt("ELECYCLE");
                Integer anneeCycle = rs.getInt("ELEANNEECYCLE");
                String mdp = rs.getString("ELEMDP");
                
                
                
                
                leEleve = new Eleve(num, nom, prenom, cycle, anneeCycle,id, mdp ); //Crée un nouvel Eleve lors de la connexion
                return leEleve;
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Erreur "+e);
        }

        return null;
        
    }

    public static Eleve getLeEleve() {
        return leEleve;
    }

    public static void setLeEleve(Eleve leEleve) {
        CrudConnexion.leEleve = leEleve;
    }
      
    
}
