/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.projetconservatoire;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author CAYUELA
 */
public class Partition {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty nomPartition  = new SimpleStringProperty();
    private StringProperty Auteur = new SimpleStringProperty();
    
   public Partition(Integer id, String nomPartition, String Auteur){
        this.id.setValue(id);
        this.nomPartition.setValue(nomPartition);
        this.Auteur.setValue(Auteur);
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public void setNomPartition(StringProperty nomPartition) {
        this.nomPartition = nomPartition;
    }

    public void setAuteur(StringProperty Auteur) {
        this.Auteur = Auteur;
    }

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getNomPartition() {
        return nomPartition;
    }

    public StringProperty getAuteur() {
        return Auteur;
    }

    public int getIdentifiant(){
        return id.get();
    }
}
