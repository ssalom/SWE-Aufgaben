import java.sql.SQLOutput;
import java.util.Scanner;

public class Cli {
    private static final int MAX_MENU_POINTS = 9;
    private static Scanner input = new Scanner(System.in);
    private static Container c;

    public void work () {
        int option;
        showMenu();
        do {
            option = readInt(0, MAX_MENU_POINTS);
            switch(option) {
                case 1: { add(); break; }
                case 2: { show(); break; }
                case 3: { open(); break; }
                case 4: { save(); break; }
                case 5: { setLimit(); break; }
                case 6: { setAlgorithm(); break; }
                case 7: { pack(); break; }
                case 8: { showHelp(); break; }
                case 9: { info(); break; }
                case 0: { exit(); break; }
            }
            showMenu();
        } while(option != 0);
    }

    static void showMenu() {
        System.out.println("Expedition");
        System.out.println("1. erfassen");
        System.out.println("2. anzeigen");
        System.out.println("3. öffnen");
        System.out.println("4. speichern");
        System.out.println("5. Limite setzen");
        System.out.println("6. Algorithmus wählen");
        System.out.println("7. Packung optimieren");
        System.out.println("8. Hilfe");
        System.out.println("9. Info");
        System.out.println("0. App beenden");
        System.out.println();
        System.out.print("Ihre Wahl: ");
    }

    static void add() {

        System.out.println("Container erfassen");
        input.reset();
        System.out.println("Name des Containers: ");
        String containerName = input.next();
        c = new Container(containerName);
        System.out.println("Name des erstellten Containers: " + c.getName());
        System.out.println("Gegenstand erfassen");
        input.reset();
        do {

            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Gewicht in kg: ");
            int weight = readInt(1, Integer.MAX_VALUE);
            System.out.print("Profit in CHF: ");
            int profit = readInt(1, Integer.MAX_VALUE);
            Item item = new Item(name, weight, profit);
            c.addItem(item);
            System.out.println(item);
            System.out.println("noch ein Gegenstand? (0 = nein, 1 = ja)");
        } while (readInt(0, 1) != 0);
    }

    static void show() {
        System.out.println("TOTAL");
        System.out.println(c.toString());
    }

    static void open() {
        Container sibirien = new Container("Sibirien");

        sibirien.addItem(new Item("Bohrstock", 4, 180));
        sibirien.addItem(new Item("Messsonde", 2, 350));
        sibirien.addItem(new Item("Borhmaschine", 8, 240));
        sibirien.addItem(new Item("Schaufel", 2, 110));
        sibirien.addItem(new Item("Pickel", 4, 120));
        sibirien.addItem(new Item("Spektrometer", 14, 180));
        System.out.println("Container wurde erstellt: " + sibirien.toString());
    }

    static void save() {
        System.out.println("speichern");
    }

    static void setLimit() {
        System.out.print("Limite in kg: ");
    }

    static void setAlgorithm() {
        System.out.println("Algorithmus wählen");
    }

    static void pack() {
        System.out.println("Packe mit Algorithmus...");
    }

    static void showHelp() {
        String text = "";
        text = "Mögliche Gegenstände für eine Expedition erfassen.";
        System.out.println(text);
    }

    static void info() {
        System.out.println("(c) M. Bontognali");
    }

    static void exit() {
        System.out.println("Bye bye!");
        System.exit(0);
    }

    static int readInt(int min, int max) {
        int value = 0;
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                value = input.nextInt();
                if (value >= min && value <= max) {
                    break;
                }
                else {
                    System.out.println("Bitte eine Ganzzahl im gültigen Bereich eingeben!");
                }
            }
            else {
                System.out.println("Bitte eine Ganzzahl eingeben!");
                input.next();
            }
        }
        return value;
    }


}
