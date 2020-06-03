class Hund {
    private String name;
    private int gewicht;

    public void gibLaut(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            gibLautNachGewicht();
        }
    }

    public String toString() {
        return this.getName() + " ist " + this.getGewicht() + " kg schwer.";
    }
    private void gibLautNachGewicht() {
        if (this.getGewicht() < 5) {
            System.out.println("Kläff");
        } else {
            System.out.println("Wuff");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
}