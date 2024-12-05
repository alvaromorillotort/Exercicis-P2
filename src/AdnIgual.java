import java.util.Scanner;

public class AdnIgual {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digues la primera cadena d'ADN:");

        String adn1 = sc.nextLine();
        char[] listaAdn1 = new char[adn1.length()];
        for (int i = 0; i < adn1.length(); i++) {
            listaAdn1[i] = adn1.charAt(i);
        }

        System.out.println("Digues la segona cadena d'ADN:");
        String adn2 = sc.nextLine();
        char[] listaAdn2 = new char[adn2.length()];
        for (int i = 0; i < adn2.length(); i++) {
            listaAdn2[i] = adn2.charAt(i);
        }

        if (sonIgualsRotades(listaAdn1, listaAdn2)) {
            System.out.println("Les dues cadenes són iguals.");
        } else {
            System.out.println("Les dues cadenes no són iguals.");
        }
    }

    static boolean sonIgualsRotades(char[] listaAdn1, char[] listaAdn2) {
        if (listaAdn1.length != listaAdn2.length) {
            return false;
        }

        for (int rotacions = 0; rotacions < listaAdn1.length; rotacions++) {
            boolean iguals = true;

            for (int i = 0; i < listaAdn1.length; i++) {
                if (listaAdn1[i] != listaAdn2[(i + rotacions) % listaAdn1.length]) {
                    iguals = false;
                    break;
                }
            }
            if (iguals) {
                return true;
            }
        }
        return false;
    }
}

