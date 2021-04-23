public class Samsung implements Handy {
    private String mFarbe;
    private boolean mZustand; //true=eingeschaltet

    public Samsung() {
        mFarbe = "Blau";
        mZustand = false;
    }

    @Override
    public void einschalten() {
        mZustand = true;
        System.out.println("Handy eingeschlatet.");
    }

    @Override
    public void ausschalten() {
        mZustand = false;
        System.out.println("Handy ausgeschaltet.");
    }

    public void verbindungsAufbau (String pNummer) {
        System.out.println("Verbindungsaufbau zu " + pNummer);
    }

    public void sendeSms(String pText, String pNummer) {
        System.out.println("Sende SMS mit Inhalt: " + pText + " an Nummer " + pNummer);
    }


}
