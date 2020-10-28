import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] saetze = {
                "Hans liebt Hunde",
                "Petra sucht Fische",
                "Claudia hat Kinder"
        };
        int anzahlOriginalSaetze = 0;


        for(int i = 1; i < 11; i++) {
            String[] neuerSatzListe = new String[3];
            String neuerSatz;
            for (int y = 0; y < 3; y++) {
                Random random = new Random();
                int randomZahl = random.nextInt(3);
                neuerSatzListe[y] = saetze[randomZahl].split(" ")[y];
            }

            neuerSatz = String.join(" ", neuerSatzListe);
            System.out.println("Satz Nr. " + i  + ": " + neuerSatz);
            for (String satz : saetze) {
                if (satz.equals(neuerSatz)) {
                    anzahlOriginalSaetze++;
                }
            }

        }

        System.out.println("Es gibt " + anzahlOriginalSaetze + " Originalsätze");
    }
}
