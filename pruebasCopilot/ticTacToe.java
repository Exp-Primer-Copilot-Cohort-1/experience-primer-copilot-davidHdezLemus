/**
 * La clase TicTacToe representa un tablero de juego de Tic-Tac-Toe.
 * Proporciona métodos para inicializar el tablero, hacer movimientos, verificar una victoria e imprimir el tablero.
 */
public class TicTacToe {
    private char[][] tablero;
    private char jugadorActual;

    /**
     * Construye un objeto TicTacToe con un tablero vacío y establece al jugador actual en 'X'.
     */
    public TicTacToe() {
        tablero = new char[3][3];
        jugadorActual = 'X';
        inicializarTablero();
    }

    /**
     * Inicializa el tablero de juego con celdas vacías representadas por '-'.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    /**
     * Imprime el estado actual del tablero de juego.
     */
    public void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Verifica si el tablero de juego está lleno.
     * @return verdadero si el tablero está lleno, falso en caso contrario.
     */
    public boolean estaTableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Realiza un movimiento en el tablero de juego en la fila y columna especificadas.
     * @param fila el índice de fila del movimiento.
     * @param columna el índice de columna del movimiento.
     * @return verdadero si el movimiento es válido y exitoso, falso en caso contrario.
     */
    public boolean hacerMovimiento(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || tablero[fila][columna] != '-') {
            return false;
        }
        tablero[fila][columna] = jugadorActual;
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        return true;
    }

    /**
     * Verifica si un jugador ha ganado el juego.
     * @return verdadero si un jugador ha ganado, falso en caso contrario.
     */
    public boolean haGanado() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != '-' && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }

        return false;
    }
}