package buscaminas;

import buscaminas.*;
import static buscaminas.casillas.fillfield;
import static buscaminas.casillas.fillvalues;
import static buscaminas.casillas.leermatriz;
import static buscaminas.casillas.leermatrizstring;
import static buscaminas.casillas.prove;

import java.util.Scanner;

public class Buscaminas {

    public static String[][] createhidden(String hiddenmatrix[][]) {

        for (int i = 0; i < hiddenmatrix.length; i++) {
            for (int j = 0; j < hiddenmatrix.length; j++) {
                hiddenmatrix[i][j] = "[]";
            }// fin del segundo for
        }// fin del primer for

        return hiddenmatrix;
    }

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);

        System.out.print("Ingrese numero : ");
        int size = lea.nextInt();
        casillas matriz[][] = new casillas[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = new casillas();
                matriz[i][j].setValor(0);
                matriz[i][j].setCosa(true);
            }
        }

        matriz = fillfield(matriz);
        matriz = fillvalues(matriz);
        gui frame = new gui();
        frame.setVisible(true);
        frame.crearfield(5, matriz); 
        leermatriz(matriz);
        prove(matriz);
         

    }// fin del main

}// fin del class
