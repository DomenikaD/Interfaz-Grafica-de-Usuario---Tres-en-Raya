/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Domenika Delgado
 */
public class Turno {
    
    //Atributos
    private int t;
    private int tX;
    private int tO;

    //Constructores
    //Constructor Vacio
    public Turno() {
    }

    //Constructor con todo los atributos de la Clase Turno
    public Turno(int t, int tX, int tO) {
        this.t = t;
        this.tX = tX;
        this.tO = tO;
    }

    //Getters & Setters
    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int gettX() {
        return tX;
    }

    public void settX(int tX) {
        this.tX = tX;
    }

    public int gettO() {
        return tO;
    }

    public void settO(int tO) {
        this.tO = tO;
    }
    
    
    
}
