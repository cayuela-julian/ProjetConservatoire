/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.projetconservatoire;

/**
 *
 * @author CAYUELA
 */
public class Discipline {
    private Integer id;
    private String nomDiscipline;
    
    
    public Discipline(Integer id, String nomDiscipline){
        this.id = id;
        this.nomDiscipline = nomDiscipline;
    }

    public Integer getId() {
        return id;
    }

    public String getNomDiscipline() {
        return nomDiscipline;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomDiscipline(String nomDiscipline) {
        this.nomDiscipline = nomDiscipline;
    }
}
