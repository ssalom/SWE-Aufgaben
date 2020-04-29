import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menuAusgabe(true);
        userMenuInput();
    }

    private static void menuAusgabe (boolean init) {
        System.out.println("Expedition");
        System.out.println("1. erfassen");
        System.out.println("2. anzeigen");
        System.out.println("0. App beenden");
        System.out.println("Ihre Wahl: ");

        if(init == false) {
            userMenuInput();
        }
    }


    private static void userMenuInput () {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            input = sc.nextInt();
            switch(input) {
                case 0:
                    System.out.println("Auf wiedersehen!");
                    break;
                case 1:
                    expeditionsGegenstandErfassen();
                    menuAusgabe(false);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Falsche eingabe.");
                    menuAusgabe(false);
            }

        } while (input == 0);
        sc.reset();
    }

    private static void expeditionsGegenstandErfassen () {
        Scanner sc = new Scanner(System.in);
        ExpeditionsGegenstand eg;
        String name;
        double weight;
        double profit;

        System.out.println("Wie soll der Gegenstand heissen?");
        name = sc.nextLine();
        System.out.println("Wie schwer ist der Gegenstand?");
        weight = sc.nextDouble();
        System.out.println("Wie gross ist der Profit des Gegenstands?");
        profit = sc.nextDouble();
        eg = new ExpeditionsGegenstand(name, weight, profit);
        sc.reset();
    }
}
