public class Ort {
    String name;
    int xPosition;
    int yPosition;

    public void anzeigen() {
        System.out.println(this.name + " befindet sich bei den Koordinaten (" + this.xPosition + "|" + this.yPosition + ")");
    }

    public double rechneDistanz(Ort ziel) {
        int xDiff = this.xPosition - ziel.xPosition;
        int yDiff = this.yPosition - ziel.yPosition;

        return Math.sqrt(
                (Math.pow(xDiff, 2) + Math.pow(yDiff, 2))
        );
    }


}
