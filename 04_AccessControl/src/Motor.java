public class Motor {
    private String name;
    private int port;
    private int drehmoment;

    public Motor(String name, int port, int drehmoment) {
        setName(name);
        setPort(port);
        setDrehmoment(drehmoment);
    }

    public void motorToString () {
        System.out.println(this.getName() + "  am Port " + this.getPort() + " un ddreht mit einem drehmoment von " + this.getDrehmoment());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        if (port >= 1 && port <=4) {
            this.port = port;
        } else {
            System.out.println(port + " ungültige Portnummer");
            System.exit(1);
        }
    }

    public int getDrehmoment() {
        return drehmoment;
    }

    public void setDrehmoment(int drehmoment) {
        this.drehmoment = drehmoment;
    }
}
