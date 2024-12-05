import java.util.*;

public class Yahztee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Benvolgut al Yahztee!");
        int[] daus = new int[5];
        tiraDados(daus); // Llamamos a tiraDados para que llene el array de valores

        if (esYahztee(daus)) { // Personalizamos el mensaje según si es Yahztee o no
            System.out.println("Felicitats! És Yahztee!");
        } else {
            System.out.println("Mala sort! Torna a intentar-ho.");
        }

    }

    static void tiraDados(int[] daus) {

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            daus[i] = random.nextInt(1, 7); // Llenamos el array daus de valores entre 1 y 6
            System.out.println(daus[i]);
        }
    }

    static boolean esYahztee(int[] daus) {
        int primerValor = daus[0];
        for (int i = 0; i < daus.length; i++) {
            if (daus[i] != primerValor) { // Si hay algún valor diferente del primero, devolverá falso y no habrá Yahztee
                return false;
            }
        }
        return true; // Si todos los valores son iguales, devolverá true y habrá Yahztee
    }
}
