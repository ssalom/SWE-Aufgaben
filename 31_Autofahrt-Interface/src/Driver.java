class Driver {
    public Rideable car;

    public void drive(){
        car.startEngine();
        car.accelerate();
        car.decelerate();
        car.brake();
        car.turnLeft();
        car.accelerate();
        car.decelerate();
        car.turnRight();
        car.brake();
        car.stopEngine();
    }

    public Rideable getCar() {
        return car;
    }

    public void setCar(Rideable car) {
        this.car = car;
    }
}
