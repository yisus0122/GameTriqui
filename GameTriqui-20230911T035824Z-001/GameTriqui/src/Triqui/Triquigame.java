package Triqui;

import java.util.Scanner;

public class Triquigame {
    public static void main(String[] args) {
        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        boolean juegoTerminado = false;
        char jugadorActual = 'X';
        int movimientos = 0;

        Scanner sc = new Scanner(System.in);

        while (!juegoTerminado) {
            mostrarTablero(tablero);

            int fila, columna;
            do {
                System.out.println("Turno de " + jugadorActual + ". Ingrese fila desde la posicion (0-2):");
                fila = sc.nextInt();
                System.out.println("Ingrese columna desde la posicion (0-2):");
                columna = sc.nextInt();
            } while (!movimientoValido(tablero, fila, columna));

            tablero[fila][columna] = jugadorActual;
            movimientos++;

            if (verificarGanador(tablero, jugadorActual)) {
                mostrarTablero(tablero);
                System.out.println("¡" + jugadorActual + " ha ganado!");
                juegoTerminado = true;
            } else if (movimientos == 9) {
                mostrarTablero(tablero);
                System.out.println("El juego ha terminado en empate.");
                juegoTerminado = true;
            } else {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    public static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public static boolean movimientoValido(char[][] tablero, int fila, int columna) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Movimiento fuera de los límites del tablero. Intente nuevamente.");
            return false;
        } else if (tablero[fila][columna] != ' ') {
            System.out.println("Esa casilla ya está ocupada. Intente nuevamente.");
            return false;
        }
        return true;
    }

    public static boolean verificarGanador(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                    (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
                (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }
        return false;
    }
}

