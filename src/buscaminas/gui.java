/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package buscaminas;

import static buscaminas.casillas.completezeros;
import static buscaminas.casillas.leermatrizstring;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

/**
 *
 * @author FAMILIA
 */
public class gui extends javax.swing.JFrame {

    private casillas cosasaurio[][];

    /**
     * Creates new form gui
     */
    public gui() {
        initComponents();

    }

    gui(casillas[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Fondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Panel_FondoLayout = new javax.swing.GroupLayout(Panel_Fondo);
        Panel_Fondo.setLayout(Panel_FondoLayout);
        Panel_FondoLayout.setHorizontalGroup(
            Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        Panel_FondoLayout.setVerticalGroup(
            Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });

    }
    
     public static void prove(casillas[][] matriz) {

        Scanner lea = new Scanner(System.in);
        boolean bandera = true;
        
        while (bandera) {
            if (matriz[0][0].getContador() >= matriz.length * matriz.length - 5) {
                System.out.println("Ha ganado !!!! Felicidades!!");
                leermatrizstring(matriz);
                bandera = false;
            } else {
                System.out.println("Seleccione las coordenadas de la fila");
                int i = lea.nextInt();

                System.out.println("Seleccione las coordenadas de la columna");
                int j = lea.nextInt();

                if (matriz[i][j].getValor() == -1 && matriz[i][j].isCosa() == true) {
                    matriz[i][j].setForma("*");
                    System.out.println("Ha perdido, cayo en una mina!!");
                    bandera = false;
                     leermatrizstring(matriz);
                } else if (matriz[i][j].getValor() != 0 && matriz[i][j].isCosa()) {
                    matriz[i][j].setForma(Integer.toString(matriz[i][j].getValor()));
                    matriz[i][j].setCosa(false);
                    matriz[0][0].setContador();
                    System.out.println("reeeeeee  1234    " +matriz[0][0].getContador());

                    leermatrizstring(matriz);
                } else if (matriz[i][j].isCosa() == false) {
                    System.out.println("Seleccione una opcion adecuada");
                } else if (matriz[i][j].getValor() == 0) {
                    matriz[0][0].setContador();
                    ArrayList<Integer> coord = new ArrayList();
                    coord = completezeros(matriz, i, j, matriz[0][0].getContador());
                    int p = 0;
                    while (coord.size() != 0) {
                        ArrayList<Integer> coord2 = new ArrayList();
                        coord2 = completezeros(matriz, coord.get(0), coord.get(1), matriz[0][0].getContador());

                        for (int e = 0; e < coord2.size(); e++) {
                            coord.add(coord2.get(e));
                        }// fin del for

                        coord.remove(0);
                        coord.remove(0);

                    }// fin del while
                    System.out.println("reeeeeee " + matriz[0][0].getContador());
                    leermatrizstring(matriz);
                }// fin del ultimo elseif
            }// fin del else
            }// fin del ultimo while

        }// fin del metodo
    
    
    
    

    // este metodo es la creacion de las minas en el gui
    public void crearfield(int size, casillas cosa[][]) {
        BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED);
        JLabel matrizminas[][] = new JLabel[5][5];
        // instancio los JLABELS Que he creado, estos jlabels que he creado son la representacion grafica de las minas
        int x = 100;
        int y = 75;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final int row = i; // Create final copy of i
                final int col = j; // Create final copy of j
                matrizminas[i][j] = new JLabel(" ");
                matrizminas[i][j].setBorder(bevelBorder);
                matrizminas[i][j].setBounds(x, y, 50, 50);
                Panel_Fondo.add(matrizminas[i][j]);
                matrizminas[i][j].setVisible(true);
                x += 50;

                matrizminas[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        matrizminas[row][col].setText(Integer.toString(cosa[row][col].getValor()));
                    }
                });
            }
            y += 50;
            x = 100;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Fondo;
    // End of variables declaration//GEN-END:variables

}
