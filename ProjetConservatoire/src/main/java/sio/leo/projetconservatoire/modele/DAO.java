/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.projetconservatoire.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CAYUELA
 */
public class DAO {
//Pour connecter mariadb et la base lardon
    private static Connection cnx = null;
    //pour exécuter des requêtes
    private static Statement smt=null;
    
    private static ResultSet rs = null;
    
    private static String requete="";
    
    //retourne la connexion à la base mariadb lardon
    public static Connection getConnection()
    {
        if(cnx==null)
        {
            SeConnecter();
        }
        return cnx;
    }
    
    //retourne le statement créé avec la connexion pour pouvoir exécuter des requêtes
    public static Statement getStatement()
    {
        if(smt==null)
        {
            try
            {
                smt=(Statement)cnx.createStatement();
            }
            catch(SQLException e)
            {
                System.out.println("Création de Statement impossible");
            }
            
        }
        return smt;
    }
    
    
    
    public static void SeConnecter() //Connexion à la BDD
    {
        String url="jdbc:mysql://192.168.5.240:3307/Conservatoire";
        String loginBd="admcons";
        String passwd="pwadmcons";
        try{
            cnx=(Connection)DriverManager.getConnection(url, loginBd, passwd);
            smt=(Statement)cnx.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception : "+e.toString());
        }
    }
        
    public static int getIntValable(){
        requete = "SELECT MAX(PARNUM) FROM PARTITIONS;";
        try{
            rs = smt.executeQuery(requete);
            if(rs.next()){
               return rs.getInt(1) + 1;
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return 0;
    } 
}