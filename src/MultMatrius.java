import java.util.*;

public class MultMatrius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digues les files de A.");
        int n = sc.nextInt();
        System.out.println("Digues les columnes de A.");
        int m = sc.nextInt();
        int[][] A = new int[n][m]; // El usuario define la dimensión de la matriz

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Digues els elements de A, en ordre.");
                A[i][j] = sc.nextInt(); // El usuario define los elementos
            }
        }
        System.out.println("A, de dimensió " + n + "x" + m + ", és: A= " + Arrays.deepToString(A)); // Damos la dimensión de A

        System.out.println("Digues les columnes de B.");
        int k = sc.nextInt();
        int[][] B = new int[m][k]; // La matriz B tiene que tener las mismas filas que columnas tiene A

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.println("Digues els elements de B, en ordre.");
                B[i][j] = sc.nextInt();
            }
        }
        System.out.println("B, de dimensió " + m + "x" + k + ", és: B = " + Arrays.deepToString(B)); // Damos la dimensión de B

        int [][] C = multiplica(n, m, k, A, B); // Llamamos a multiplica para que calcule C
        System.out.println("La matriu C resultant és: " + Arrays.deepToString(C)); // Imprimimos C

    }
    static int [][] multiplica(int n, int m, int k, int [][] A, int [][] B) {
        int[][] C = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] += (A[i][j] * B[i][j]); // Calculamos cada elemento [i][j] de C
            }
        }
        return C;
    }
}
