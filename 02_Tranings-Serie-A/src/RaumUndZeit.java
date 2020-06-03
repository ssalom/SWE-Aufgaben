import java.util.Date;
import java.text.SimpleDateFormat;

public class RaumUndZeit {
    public static void main(String[] args) {
        aufgabe1();
        System.out.println("---------------");
        aufgabe2();
        System.out.println("---------------");
        aufgabe3();
        System.out.println("---------------");
        aufgabe4();
    }

    public static void aufgabe1 () {
        int xPosition1 = 165;
        int yPosition1 = 142;
        int xPosition2 = 185;
        int yPosition2 = 131;
        int xDiff = Math.abs(xPosition1 - xPosition2);
        int yDiff = Math.abs(yPosition1 - yPosition2);

        double distanz = Math.sqrt(
                (Math.pow(xDiff, 2) + Math.pow(yDiff, 2))
        );

        System.out.println("Distanz beträgt: " + Math.round(distanz));

    }

    public static void aufgabe2 () {
        int sekunden = 5;
        int minuten = 3;
        int stunden = 1;

        System.out.println(sekunden + (minuten * 60) + (stunden * 360));
    }

    public static void aufgabe3 () {
        int sekunden = 5000;
        int miliSekunden = sekunden * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        date.setTime(miliSekunden);

        System.out.println(sdf.format(date));
    }

    public static void aufgabe4 () {
        double distanz = 300; //km
        double geschwindigkeit = 120; //km/h
        double reisezeit = distanz / geschwindigkeit;

        System.out.println(reisezeit);
    }
}
