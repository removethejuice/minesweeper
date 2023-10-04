package buscaminas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class casillas {

    int valor;
    String forma = "[]";
    boolean cosa;
    int contador;

    public casillas(int valor, boolean cosa, String forma, int contador) {
        this.valor = valor;
        this.cosa = cosa;// si la cosa es true significa que no se le ha dado vuelta, si esta false significa que hay un marcador que no permite dar vuelta
        // o que ya se ha dado vuelta la mina
        this.forma = forma;
        this.contador = 0 ;
    }

    public casillas() {

    }

    public int getValor() {
        return valor;
    }

    public String getForma() {
        return forma;
    }

    public boolean isCosa() {
        return cosa;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setContador() {
        this.contador = contador +1;
    }

    public int getContador() {
        return contador;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setCosa(boolean cosa) {
        this.cosa = cosa;
    }

    @Override
    public String toString() {
        return "casillas{" + "valor=" + valor + ", forma=" + forma + ", cosa=" + cosa + '}';
    }

    public static casillas[][] fillvalues(casillas[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {

                /*     0* 0* 0*
                       0 0! 0 
                       0 0 0
                 parte de arriba osea del centro para arriba */
                if (i != 0 && matriz[i][j].getValor() != -1) {

                    if (matriz[i - 1][j].getValor() == -1) {
                        matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                    }// fin del segundo if
                    if (j != 0) {
                        if (matriz[i - 1][j - 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }// fin del tercer if
                    } // fin del condicional para las esquinas

                    if (j != matriz.length - 1) {
                        if (matriz[i - 1][j + 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }// fin del cuarto if
                    }// fin del condicional para las esquinas
                }//fin del primer if principal, para la parte de arriba
                /*     0  0  0
                       0  0! 0 
                       0* 0* 0*
                 parte de arriba osea del centro para abajo */
                if (i != matriz.length - 1 && matriz[i][j].getValor() != -1) {
                    if (matriz[i + 1][j].getValor() == -1) {
                        matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                    }// fin del segundo if
                    if (j != 0) {
                        if (matriz[i + 1][j - 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }// fin del tercer if
                    }// fin del condicional para las esquinas
                    if (j != matriz.length - 1) {
                        if (matriz[i + 1][j + 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }// fin del cuarto if
                    }// fin del condicional para las esquinas
                }// fin del segundo if principal, para la parte de abajo

                /*     0 0 0
                       0* 0! 0* 
                       0 0 0
                 parte de arriba osea del centro para el centro */
                if (matriz[i][j].getValor() != -1) {

                    if (j != 0) {
                        if (matriz[i][j - 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }// fin del if
                    }// fin de la primera condicional para las esquinas
                    if (j != matriz.length - 1) {
                        if (matriz[i][j + 1].getValor() == -1) {
                            matriz[i][j].setValor(matriz[i][j].getValor() + 1);
                        }//fin del if anidado
                    }// fin del if principal

                }// fin del if del centro

            }//fin del segundo for

        }//fin del primer for

        return matriz;
    }// fin del metodo

    public static void leermatrizstring(casillas[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j].getForma());
                System.out.print("   ");
            }//fin del segundo for
            System.out.println();
        }//fin del primer for

    }// fin del metodo de leer matrizstring

    public static void leermatriz(casillas[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j].getValor());
                System.out.print("   ");
            }//fin del segundo for
            System.out.println();
        }//fin del primer for

    }//fin del metodo leermatriz

    public static casillas[][] fillfield(casillas[][] matriz) {
// el valor que en este caso es 5,indica el numero de minas que contendra el field
        for (int i = 0; i < 5; i++) {
            Random mines = new Random();
            Random mines2 = new Random();
            int n = mines.nextInt(matriz.length);
            int n2 = mines2.nextInt(matriz.length);
            // si el valor seleccionado ya es una mina se vuelve a rolear para con suerte encontrar un valor que no sea una mina
            if (matriz[n][n2].getValor() == -1) {
                i--;
            }
            matriz[n][n2].setValor(-1);

        }// fin del for
        return matriz;
    }// fin del metodo fillfield

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

    

    public static ArrayList<Integer> completezeros(casillas[][] matriz, int x, int y, int contador) {

        ArrayList<Integer> coordenadas = new ArrayList();
       
        System.out.println("kkkkkkk el contador " + contador);
        matriz[x][y].setForma(Integer.toString(matriz[x][y].getValor()));
        matriz[x][y].setCosa(false);

        /*     0* 0* 0*
                       0 0! 0 
                       0 0 0
                 parte de arriba osea del centro para arriba */
        if (x != 0) {
            if (matriz[x - 1][y].isCosa()) {
                matriz[x - 1][y].setForma(Integer.toString(matriz[x - 1][y].getValor()));
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                matriz[x - 1][y].setCosa(false);
                if (matriz[x - 1][y].getValor() == 0) {
                    coordenadas.add(x - 1);
                    coordenadas.add(y);
                }
            }// fin del if de is cosa
            if (y != 0 && matriz[x - 1][y - 1].isCosa()) {
                matriz[x - 1][y - 1].setForma(Integer.toString(matriz[x - 1][y - 1].getValor()));
                matriz[x - 1][y - 1].setCosa(false);
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                if (matriz[x - 1][y - 1].getValor() == 0) {
                    coordenadas.add(x - 1);
                    coordenadas.add(y - 1);
                }// fin del if para agregar coordenadas

            } // fin del condicional para las esquinas

            if (y != matriz.length - 1 && matriz[x - 1][y + 1].isCosa()) {
                matriz[x - 1][y + 1].setForma(Integer.toString(matriz[x - 1][y + 1].getValor()));
                matriz[x - 1][y + 1].setCosa(false);
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                if (matriz[x - 1][y + 1].getValor() == 0) {
                    coordenadas.add(x - 1);
                    coordenadas.add(y + 1);
                }// fin del cuarto if

            }// fin del condicional para las esquinas
        }//fin del primer if principal, para la parte de arriba
        /*             0  0  0
                       0  0! 0 
                       0* 0* 0*
                 parte de arriba osea del centro para abajo */
        if (x != matriz.length - 1) {
            if (matriz[x + 1][y].isCosa()) {
                matriz[x + 1][y].setForma(Integer.toString(matriz[x + 1][y].getValor()));
                matriz[x + 1][y].setCosa(false);
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                if (matriz[x + 1][y].isCosa() && matriz[x + 1][y].getValor() == 0) {
                    coordenadas.add(x + 1);
                    coordenadas.add(y);

                }// fin del segundo if
            }// fin del is cosa
            if (y != 0 && matriz[x + 1][y - 1].isCosa()) {
                matriz[x + 1][y - 1].setForma(Integer.toString(matriz[x + 1][y - 1].getValor()));
                matriz[x + 1][y - 1].setCosa(false);
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                if (matriz[x + 1][y - 1].getValor() == 0) {
                    coordenadas.add(x + 1);
                    coordenadas.add(y - 1);
                }// fin del tercer if

            }// fin del condicional para las esquinas
            if (y != matriz.length - 1 && matriz[x + 1][y + 1].isCosa()) {
                matriz[x + 1][y + 1].setForma(Integer.toString(matriz[x + 1][y + 1].getValor()));
                 matriz[0][0].setContador();
                System.out.println("kkkkkkk el contador " + contador);
                matriz[x + 1][y + 1].setCosa(false);
                if (matriz[x + 1][y + 1].getValor() == 0) {
                    coordenadas.add(x + 1);
                    coordenadas.add(y + 1);

                }// fin del cuarto if

            }// fin del condicional para las esquinas
        }// fin del segundo if principal, para la parte de abajo

        /*     0 0 0
                       0* 0! 0* 
                       0 0 0
                 parte de arriba osea del centro para el centro */
        if (y != 0 && matriz[x][y - 1].isCosa()) {
            matriz[x][y - 1].setForma(Integer.toString(matriz[x][y - 1].getValor()));
            matriz[x][y - 1].setCosa(false);
             matriz[0][0].setContador();
            System.out.println("kkkkkkk el contador " + contador);
            if (matriz[x][y - 1].getValor() == 0) {
                coordenadas.add(x);
                coordenadas.add(y - 1);

            }// fin del if
        }// fin de la primera condicional para las esquinas
        if (y != matriz.length - 1 && matriz[x][y + 1].isCosa()) {
            matriz[x][y + 1].setForma(Integer.toString(matriz[x][y + 1].getValor()));
             matriz[0][0].setContador();
            System.out.println("kkkkkkk el contador " + contador);
            matriz[x][y + 1].setCosa(false);

            if (matriz[x][y + 1].getValor() == 0) {
                coordenadas.add(x);
                coordenadas.add(y + 1);

            }//fin del if anidado
        }// fin del if principal

        return coordenadas;
    }// fin del metodo

}//fin del class
