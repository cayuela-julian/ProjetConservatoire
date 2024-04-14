/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.projetconservatoire;

/**
 *
 * @author CAYUELA
 */
public class Eleve {
    private Integer id;
    private String Nom;
    private String Prenom;
    private Integer Cycle;
    private Integer AnneeCycle;
    private String login;
    private String mdp;
    
    public Eleve(Integer id, String Nom, String Prenom, Integer Cycle, Integer AnneeCycle, String login, String mdp){
        this.id = id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Cycle = Cycle;
        this.AnneeCycle = AnneeCycle;
        this.login = login;
        this.mdp = mdp;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public Integer getCycle() {
        return Cycle;
    }

    public Integer getAnneeCycle() {
        return AnneeCycle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setCycle(Integer Cycle) {
        this.Cycle = Cycle;
    }

    public void setAnneeCycle(Integer AnneeCycle) {
        this.AnneeCycle = AnneeCycle;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    
}
