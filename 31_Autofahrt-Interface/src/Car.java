public class Car implements Rideable {
    public boolean engineOn;
    public boolean accelerating;
    public String model;

    public Car(String model) {
        engineOn = false;
        accelerating = false;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Motor starten.");
        engineOn = true;
    }

    @Override
    public void accelerate() {
        System.out.println("Beschleunigen.");
        accelerating = true;
    }

    @Override
    public void decelerate() {
        System.out.println("Entschleunigen.");
        accelerating = false;
    }

    @Override
    public void stopEngine() {
        System.out.println("Motor stoppen.");
        engineOn = false;
    }

    @Override
    public void brake() {
        System.out.println("Bremsen.");
        accelerating = false;
    }

    @Override
    public void turnLeft() {
        System.out.println("Links abbiegen.");
    }

    @Override
    public void turnRight() {
        System.out.println("Rechts abbiegen.");
    }
}
