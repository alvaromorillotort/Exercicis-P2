import java.util.*;

public class JocNegocis {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Benvolugut al joc dels negocis! Començes a jugar amb 100 euros.");
        int dias = 10;
        int dinersUsuari = 100;
        int preuPomes = 10, preuPeres = 10;
        System.out.println("El preu de les pomes i de les peres és de 10 euros.");
        int pomesUsuari = 0, peresUsuari = 0;

        while (dias > 0) {

            System.out.println("Queden " + dias + " dies per el final. Quants diners podràs aconseguir?");
            System.out.println("Els preus d'avui són: ");
            System.out.println("Pomes - " + preuPomes + " euros");
            System.out.println("Peres - " + preuPeres + " euros");
            System.out.println("Què vols fer?");
            System.out.println("Pulsa 1 per comprar pomes, 2 per comprar peres, 3 per vendre pomes,");
            System.out.println("4 per vendre peres, 5 per veure els teus diners, 6 per passar de dia.");
            System.out.println("7 per acabar el joc");
            int comando = sc.nextInt();

            switch (comando) {
                case 1:
                    System.out.println("Quantes pomes vols?");
                    int pomesPerComprar = sc.nextInt();
                    int[] compraPomesResult = compraPomes(pomesUsuari, dinersUsuari, preuPomes, pomesPerComprar);
                    pomesUsuari = compraPomesResult[0];
                    dinersUsuari = compraPomesResult[1];
                    break;

                case 2:
                    System.out.println("Quantes peres vols?");
                    int peresPerComprar = sc.nextInt();
                    int[] compraPeresResult = compraPeres(peresUsuari, dinersUsuari, preuPeres, peresPerComprar);
                    peresUsuari = compraPeresResult[0];
                    dinersUsuari = compraPeresResult[1];
                    break;

                case 3:
                    System.out.println("Quantes pomes vols vendre?");
                    int pomesPerVendre = sc.nextInt();
                    int[] vendrePomesResult = vendrePomes(pomesUsuari, preuPomes, dinersUsuari, pomesPerVendre);
                    pomesUsuari = vendrePomesResult[0];
                    dinersUsuari = vendrePomesResult[1];
                    break;

                case 4:
                    System.out.println("Quantes peres vols vendre?");
                    int peresPerVendre = sc.nextInt();
                    int[] vendrePeresResult = vendrePeres(peresUsuari, preuPeres, dinersUsuari, peresPerVendre);
                    peresUsuari = vendrePeresResult[0];
                    dinersUsuari = vendrePeresResult[1];
                    break;

                case 5:
                    menu(dinersUsuari, pomesUsuari, peresUsuari, preuPomes, preuPeres);
                    break;

                case 6:
                    System.out.println("Passant al següent dia...");
                    dias--;
                    preuPomes = calcularNouPreu(preuPomes);
                    preuPeres = calcularNouPreu(preuPeres);
                    break;

                case 7:
                    System.out.println("Has finalitzat el joc amb " + dinersUsuari + " euros!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opció no vàlida. Escull una altra d'entre les opcions.");
                    break;
            }
            if (comando != 6) {
                System.out.println("Vols fer una altra cosa? (S/N)");
                String resposta = sc.next();
                if (resposta.equalsIgnoreCase("n")) {
                    System.out.println("Passant al següent dia...");
                    dias--;
                    preuPomes = calcularNouPreu(preuPomes);
                    preuPeres = calcularNouPreu(preuPeres);
                }
            }
        }
        System.out.println("Final del joc! Has acconseguit acumular " + dinersUsuari + " euros!");
    }

    static int calcularNouPreu(int preuActual) {
        Random rand = new Random();
        int fluctuacion = rand.nextBoolean() ? 2 : -2;
        if (preuActual == 1 && fluctuacion < 0) {
            fluctuacion = 2;
        }
        preuActual += fluctuacion;

        if (preuActual < 1) preuActual = 1;
        return preuActual;
    }

    static int[] vendrePomes(int pomesUsuari, int preuPomes, int dinersUsuari, int pomesPerVendre) {
        if (pomesUsuari >= pomesPerVendre) {
            dinersUsuari += (pomesPerVendre * preuPomes);
            pomesUsuari -= pomesPerVendre;
            System.out.println("Has venut " + pomesPerVendre + " pomes, ara tens " + dinersUsuari + " euros.");
        } else {
            System.out.println("No tens suficients pomes per vendre.");
        }
        return new int[]{pomesUsuari, dinersUsuari};
    }

    static int[] vendrePeres(int peresUsuari, int preuPeres, int dinersUsuari, int peresPerVendre) {
        if (peresUsuari >= peresPerVendre) {
            dinersUsuari += (peresPerVendre * preuPeres);
            peresUsuari -= peresPerVendre;
            System.out.println("Has venut " + peresPerVendre + " peres, ara tens " + dinersUsuari + " euros.");
        } else {
            System.out.println("No tens suficients peres per vendre.");
        }
        return new int[] {peresUsuari, dinersUsuari};
    }

    static int[] compraPomes(int pomesUsuari, int dinersUsuari, int preuPomes, int pomesPerComprar) {
        if (dinersUsuari >= (preuPomes * pomesPerComprar)) {
            dinersUsuari -= (preuPomes * pomesPerComprar);
            pomesUsuari += pomesPerComprar;
            System.out.println("Has comprat " + pomesPerComprar + " pomes, ara tens " + dinersUsuari + " euros.");
        } else {
            System.out.println("No tens diners suficients.");
        }
        return new int[]{pomesUsuari, dinersUsuari};
    }

    static int[] compraPeres(int peresUsuari, int dinersUsuari, int preuPeres, int peresPerComprar) {
        if (dinersUsuari >= (preuPeres * peresPerComprar)) {
            dinersUsuari -= (preuPeres * peresPerComprar);
            peresUsuari += peresPerComprar;
            System.out.println("Has comprat " + peresPerComprar + " peres, ara tens " + dinersUsuari + " euros.");
        } else {
            System.out.println("No tens diners suficients.");
        }
        return new int[]{peresUsuari, dinersUsuari};
    }

    static void menu(int dinersUsuari, int pomesUsuari, int peresUsuari, int preuPomes, int preuPeres) {
        System.out.println("Dinero: " + dinersUsuari + " euros.");
        System.out.println("Manzanas: " + pomesUsuari + ", Precio por unidad: " + preuPomes + " euros.");
        System.out.println("Peras: " + peresUsuari + ", Precio por unidad: " + preuPeres + " euros.");
    }
}