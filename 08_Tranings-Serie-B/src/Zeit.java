import java.text.SimpleDateFormat;
import java.util.Date;

public class Zeit {
    int stunden;
    int minuten;
    int sekunden;

    public void anzeigen() {
        System.out.println("Stunden: " + this.stunden + "  Minuten: " + this.minuten + "  Sekunde: " + this.sekunden);
    }

    public int inSekunden() {
        return (this.sekunden + (this.minuten * 60) + (this.stunden * 3600));
    }

    public void setSekMinStd(int sek) {
        this.stunden = (sek / 3600);
        this.minuten = ((sek % 3600) / 60);
        this.sekunden = ((sek % 3600) % 60);
    }

    public Zeit add(Zeit zeit) {
        int sek1 = this.inSekunden();
        int sek2 = zeit.inSekunden();
        Zeit newZeit = new Zeit();

        newZeit.setSekMinStd(sek1 + sek2);

        return newZeit;
    }
}
