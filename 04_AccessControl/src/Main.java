public class Main {

    public static void main(String[] args) {
        TouchSensor touch1 = new TouchSensor("Taste 1", 3);
        TouchSensor touch2 = new TouchSensor("Taste 2", 4);



        System.out.println(touch1.getName() + "ist am Port " + touch1.getPort());
        System.out.println(touch2.getName() + "ist am Port " + touch2.getPort());





    }
}
