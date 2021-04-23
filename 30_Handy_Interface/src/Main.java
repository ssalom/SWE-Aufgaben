public class Main {

    public static void main(String[] args) {
        Handy samsung = new Samsung();

        samsung.einschalten();
        samsung.verbindungsAufbau("079 123 45 67");
        samsung.sendeSms("Hallo", "079 123 45 67");
        samsung.ausschalten();
    }

}
