public class TestKlasse {
    public static void main(String[] args) {
        Ort genf = new Ort();
        Ort arrau = new Ort();
        Ort baden = new Ort();
        Ort zuerich = new Ort();

        Zeit zeit1 = new Zeit();
        Zeit zeit2 = new Zeit();

        //zeit1.setSekMinStd(5000);
        zeit1.sekunden = 50;
        zeit1.minuten = 45;
        zeit1.stunden = 0;
        zeit2.sekunden = 50;
        zeit2.minuten = 45;
        zeit2.stunden = 1;


        //genf
        genf.name = "Genf";
        genf.xPosition = 0;
        genf.yPosition = 0;

        //arrau
        arrau.name = "Arrau";
        arrau.xPosition = 146;
        arrau.yPosition = 135;

        //baden
        baden.name = "Baden";
        baden.xPosition = 165;
        baden.yPosition = 142;

        //zuerich
        zuerich.name = "Zürich";
        zuerich.xPosition = 185;
        zuerich.yPosition = 131;


        baden.anzeigen();
        System.out.println("Baden befindet sich " + baden.rechneDistanz(zuerich) + " km von " + zuerich.name + " entfernt!");

        zeit1.anzeigen();
        zeit2.anzeigen();

        System.out.println("Sekunden zeit1: " + zeit1.inSekunden());
        System.out.println("Sekunden zeit2: " + zeit2.inSekunden());

        zeit1.add(zeit2).anzeigen();

        System.out.println("Sekunden zeit1: " + zeit1.inSekunden());
        System.out.println("Sekunden zeit2: " + zeit2.inSekunden());
    }
}
