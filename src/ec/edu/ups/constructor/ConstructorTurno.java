/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.constructor;

import ec.edu.ups.modelo.Turno;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author Domenika Delgado
 */
public class ConstructorTurno {
    
    Turno claseT = new Turno();
    
    
     public int formasDeGanar(int matriz[][]) {
       
        //Formass de ganar horizontal 1
        if (matriz[0][0] == matriz[0][1] & matriz[0][0] == matriz[0][2]) {
            return 1; 
            
        }
        //Horizontal 2
        if (matriz[1][0] == matriz[1][1] & matriz[1][0] == matriz[1][2]) {
            return 2;
        }
        //Horizontal 3
        if (matriz[2][0] == matriz[2][1] & matriz[2][0] == matriz[2][2]) {
            return 3;
        }

        //Formas de ganar vertical 1
        if (matriz[0][0] == matriz[1][0] & matriz[0][0] == matriz[2][0]) {
            return 4;
        }
        
        //Vertical 2
        if (matriz[0][1] == matriz[1][1] & matriz[0][1] == matriz[2][1]) {
            return 5;
        }
    
        //Vertical 3
        if (matriz[0][2] == matriz[1][2] & matriz[0][2] == matriz[2][2]) {
            return 6;
        }

        //Formas de ganar diagonal 1
        if (matriz[0][0] == matriz[1][1] & matriz[0][0] == matriz[2][2]) {
            return 7;
        }
        //Diagonal 2
        if (matriz[0][2] == matriz[1][1] & matriz[0][2] == matriz[2][0]) {
            return 8;
        }
        
        return 0;
    }
    
    public int jugada(JButton botonTurno, int i, int j, int matriz[][], JLabel jX, JLabel jO) {
        matriz[i][j] = claseT.getT();
        String n = new String();
        if (claseT.getT() == 0) {
            n = "X";
            botonTurno.setForeground(Color.red);
        }
        
       //intercambiar();
        botonTurno.setText(n);
        botonTurno.setEnabled(false);
        
        if(formasDeGanar(matriz)!=0){
            JOptionPane.showMessageDialog(null, "Ganador: "+n);
            
            if(claseT.getT()==1){
                claseT.settX(claseT.gettX()+1);
                jX.setText(String.valueOf(claseT.gettX()));
            }
            
            if(claseT.getT()==0){
                claseT.settO(claseT.gettO()+1);
                jO.setText(String.valueOf(claseT.gettO()));
            }
            return 1;
        }
        return 0;
    }
    
    
    public void raya(int matriz[][], JPanel p, int n, int i, int j){
        matriz[i][j]=claseT.getT();
        if(formasDeGanar(matriz)==n){
            p.setVisible(true);
        }
    }
}
