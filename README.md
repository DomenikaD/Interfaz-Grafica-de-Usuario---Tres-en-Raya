# Interfaz-Grafica-de-Usuario---Tres-en-Raya
Una interfaz grafica de usuario del juego de tres en raya con base a layouts, botones e imágenes. 


INFORME

 	PRÁCTICA DE LABORATORIO 

CARRERA: Computación			ASIGNATURA: Programación Aplicada
NRO. PRÁCTICA:	4			TÍTULO PRÁCTICA: Interfaz Gráfica de Usuario (Calculadora, Tres en Raya & El Ahorcado)
OBJETIVO ALCANZADO: Construir interfaces gráficas de usuario
ACTIVIDADES DESARROLLADAS

Tres en Raya
1.	Creación de un repositorio en GitHub:
 

Link: https://github.com/DomenikaD/Interfaz-Grafica-de-Usuario---Tres-en-Raya
Usuario: DomenikaD
2.	Commits:
 
3.	Paquetes constructor, imagen, modelo & vista:
 

4.	Código:
Clase ConstructorTurno
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
       
        //Formas de ganar horizontal 1
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
    
    public int jugada(JButton botonTurno, int i, int j, int matriz[][]) {
        matriz[i][j] = claseT.getT();
        String n = new String();
        if (claseT.getT() == 0) {
            n = "X";
            botonTurno.setForeground(Color.MAGENTA);
        }
        
       //intercambiar();
        botonTurno.setText(n);
        botonTurno.setEnabled(false);
        
        if(formasDeGanar(matriz)!=0){
            JOptionPane.showMessageDialog(null, "Ganador: "+n);
            
            if(claseT.getT()==1){
                claseT.settX(claseT.gettX()+1);
                //jX.setText(String.valueOf(claseT.gettX()));
            }
            
            if(claseT.getT()==0){
                claseT.settO(claseT.gettO()+1);
                //jO.setText(String.valueOf(claseT.gettO()));
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
    
    public void raya(int matriz[][], JLabel p, int n, int i, int j){
        matriz[i][j]=claseT.getT();
        if(formasDeGanar(matriz)==n){
            p.setVisible(true);
        }
    }
}


Paquete Imagen

 

Clase Turno
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

JFrame Ventana Principal
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.constructor.ConstructorTurno;
import ec.edu.ups.modelo.Turno;
import java.awt.Color;

/**
 *
 * @author Domenika Delgado
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal1
     */
    public VentanaPrincipal() {
        initComponents();
        ingresar();
        
        //lineas horizontales
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);

        //lineas verticales
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);

        //lineas horizontales
        jLabel10.setVisible(false);
        jLabel9.setVisible(false);

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tres en Raya");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 5, 240, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 10, 330));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 330, 10));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 330, 10));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 330, 10));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 90));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 90, 90));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 90, 90));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 90));

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 90, 90));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 90, 90));

        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 90, 90));

        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 90, 90));

        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 90, 90));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/imagen/fondo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 380, 340));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 210));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 270, 220));

        jButton10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 204, 102));
        jButton10.setText("Jugar de Nuevo");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 160, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Domenika Delgado\\Desktop\\246x0w.jpg")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    
    //Iniciamos creando una matriz 
    private int matriz[][] = new int[3][3];

    //Creamos un metodo para ingresar los metodos
    public void ingresar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = (j + 10) * (i + 10);
            }
        }
    }

   
    ConstructorTurno ct = new ConstructorTurno();
    //Metodo para desarrollar la opcion a elegir

    
    //Metodo para crear un nuevo juego

    public void reiniciar() {
        ingresar();
        //Botones 1 a 9
        jButton1.setText("");
        jButton1.setEnabled(true);

        jButton2.setText("");
        jButton2.setEnabled(true);

        jButton3.setText("");
        jButton3.setEnabled(true);

        jButton4.setText("");
        jButton4.setEnabled(true);

        jButton5.setText("");
        jButton5.setEnabled(true);

        jButton6.setText("");
        jButton6.setEnabled(true);

        jButton7.setText("");
        jButton7.setEnabled(true);

        jButton8.setText("");
        jButton8.setEnabled(true);

        jButton9.setText("");
        jButton9.setEnabled(true);
        
        //lineas horizontales 
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel9.setVisible(false);
        //lineas verticales
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        
        

        

    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //diagonal
        ct.raya(matriz, jLabel10, 7, 0, 0);
        //horizontal
        ct.raya(matriz, jPanel7, 1, 0, 0);
        //vertical
        ct.raya(matriz, jPanel4, 4, 0, 0);

        if (ct.jugada(jButton1, 0, 0, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //horizontal
        ct.raya(matriz, jPanel7, 1, 0, 1);
        //vertical
        ct.raya(matriz, jPanel3, 5, 0, 1);

        if (ct.jugada(jButton2, 0, 1, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //horizontal
        ct.raya(matriz, jPanel7, 1, 0, 2);
        //vertical
        ct.raya(matriz, jPanel2, 6, 0, 2);
        //diagonal
        ct.raya(matriz, jPanel9, 8, 0, 2);

        if (ct.jugada(jButton3, 0, 2, matriz) == 1) {
        }
        computadora();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //horizontal
        ct.raya(matriz, jPanel8, 2, 1, 0);
        //vertical
        ct.raya(matriz, jPanel4, 4, 1, 0);

        if (ct.jugada(jButton4, 1, 0, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //diagonal
        ct.raya(matriz, jLabel10, 7, 1, 1);
        ct.raya(matriz, jLabel9, 8, 1, 1);
        //horizontal
        ct.raya(matriz, jPanel8, 2, 1, 1);
        //vertical
        ct.raya(matriz, jPanel3, 5, 1, 1);

        if (ct.jugada(jButton5, 1, 1, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //horizontal
        ct.raya(matriz, jPanel8, 2, 1, 2);
        //vertical
        ct.raya(matriz, jPanel4, 6, 1, 2);

        if (ct.jugada(jButton6, 1, 02, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ct.raya(matriz, jPanel9, 3, 2, 0);
        //vertical
        ct.raya(matriz, jPanel4, 4, 2, 0);
        //diagonal
        ct.raya(matriz, jLabel9, 8, 2, 0);

        if (ct.jugada(jButton7, 2, 0, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //horizontal
        ct.raya(matriz, jPanel9, 3, 2, 1);
        //vertical
        ct.raya(matriz, jPanel3, 5, 2, 1);

        if (ct.jugada(jButton8, 2, 1, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //diagonal
        ct.raya(matriz, jLabel10, 7, 2, 2);
        //horizontal
        ct.raya(matriz, jPanel9, 3, 2, 2);
        //vertical
        ct.raya(matriz, jPanel2, 6, 2, 2);

        if (ct.jugada(jButton9, 2, 2, matriz) == 1) {

        }
        computadora();
    }                                        

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        reiniciar();
    }                                         

    public boolean gano = false;

    public void computadora() {
        if (gano == false) {
            
            int p = (int) (Math.random() * (9 + 1));
            if (p == 1) {
                if (jButton1.getText().equals("")) {
                    jButton1.setText("O");
                    jButton1.setForeground(Color.green);  
                }
                else{
                    p++;  
                }
            }
             
            if (p == 2) {
                if (jButton2.getText().equals("")) {
                    jButton2.setText("O");
                    jButton2.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 3) {
                if (jButton3.getText().equals("")) {
                    jButton3.setText("O");
                    jButton3.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 4) {
                if (jButton4.getText().equals("")) {
                    jButton4.setText("O");
                    jButton4.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 5) {
                if (jButton5.getText().equals("")) {
                    jButton5.setText("O");
                    jButton5.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 6) {
                if (jButton6.getText().equals("")) {
                    jButton6.setText("O");
                    jButton6.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 7) {
                if (jButton7.getText().equals("")) {
                    jButton7.setText("O");
                    jButton7.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 8) {
                if (jButton8.getText().equals("")) {
                    jButton8.setText("O");
                    jButton8.setForeground(Color.green);
                }else{
                    p++;
                }
            }
            if (p == 9) {
                if (jButton9.getText().equals("")) {
                    jButton9.setText("O");
                    jButton9.setForeground(Color.green);
                }else{
                    p++;
                }
                
            }
            
        } 
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration                   
}




5.	Diseño:

 
6.	Funcionamiento:
 
Ejemplo:
 
7.	Explicación del funcionamiento de la Interfaz gráfica de usuario – Tres en Raya:
Este proyecto es sobre el juego de Tres en Raya, que se desarrolla en el lenguaje de programación de Java. El juego es contra la computadora, con el usuario comenzando primero.


CONCLUSIONES: Podemos llegar a realizar diferentes interfaces utilizando código que nos puede generar Netbeans, de esto se puede entender el funcionamiento de casa cosa & tener en cuenta que un arreglo puede ser muy útil al rato de crear juegos, como por ejemplo: Tres en Raya & El Ahorcado. 


RECOMENDACIONES: Tener en cuenta la implementación con base de layouts, los botones y cajas de texto que nos permite realizar en un JFrame  y tener como resultado el código Generadotra. Ejemplo: La calculadora.


Nombre de estudiante: Domenika Delgado


Firma de estudiante:  ![8](https://user-images.githubusercontent.com/49033904/57277951-d857fc80-706a-11e9-9b3e-f022b2245bbe.jpg)


