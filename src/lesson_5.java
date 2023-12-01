public class lesson_5 {
    public static void main(){
        //1
        Vehicle[] vehicles = {new Car(), new Motorcycle()};
        controlVehicles(vehicles);

        //2
        ElectronicDevice[] devices = {new Television(), new Computer()};
        controlElectronDevices(devices);

        //3
        Dish[] dishes = {new Soup(), new Steak()};
        prepareDishes(dishes);
    }

    public static void controlVehicles(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.start();
                car.stop();
            } else if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                motorcycle.start();
                motorcycle.stop();
            }
        }
    }

    public static void controlElectronDevices(ElectronicDevice[] devices) {
        for (ElectronicDevice device : devices) {
            if (device instanceof Television) {
                Television tv = (Television) device;
                tv.turnOn();
                tv.turnOff();
            } else if (device instanceof Computer) {
                Computer computer = (Computer) device;
                computer.turnOn();
                computer.turnOff();
            }
        }
    }

    static void prepareDishes(Dish[] dishes) {
        for (Dish dish : dishes) {
            if (dish instanceof Soup) {
                Soup soup = (Soup) dish;
                soup.cook();
            } else if (dish instanceof Steak) {
                Steak steak = (Steak) dish;
                steak.cook();
            }
        }
    }


}


interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

}

interface ElectronicDevice {
    void turnOn();
    void turnOff();
}

class Television implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off");
    }
}

class Computer implements ElectronicDevice {
    @Override
    public void turnOn() {
        System.out.println("Computer is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Computer is turned off");
    }
}

interface Dish {
    void cook();
}

class Soup implements Dish {
    @Override
    public void cook() {
        System.out.println("Cooking soup");
    }
}

class Steak implements Dish {
    @Override
    public void cook() {
        System.out.println("Cooking steak");
    }
}