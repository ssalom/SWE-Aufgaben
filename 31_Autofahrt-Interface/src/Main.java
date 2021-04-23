public class Main {

    public static void main(String[] args) {
        Rideable bmw = new Car("BMW M3");
        Driver james = new Driver();

        james.setCar(bmw);
        james.drive();

    }
}
