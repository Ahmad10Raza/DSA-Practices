// Interface for a general electronic device
interface ElectronicDevice {
    void turnOn();
    void turnOff();
}

// Interface for a device with display capability
interface DisplayDevice {
    void displayOn();
    void displayOff();
}

// Interface for a device with internet connectivity
interface InternetEnabledDevice {
    void connectToInternet();
    void disconnectFromInternet();
}

// Concrete class implementing ElectronicDevice and DisplayDevice interfaces
class Television implements ElectronicDevice, DisplayDevice {
    @Override
    public void turnOn() {
        System.out.println("Television is powered on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Television is powered off.");
    }

    @Override
    public void displayOn() {
        System.out.println("Display is on.");
    }

    @Override
    public void displayOff() {
        System.out.println("Display is off.");
    }
}

// Concrete class implementing ElectronicDevice and InternetEnabledDevice interfaces
class SmartPhone implements ElectronicDevice, InternetEnabledDevice {
    @Override
    public void turnOn() {
        System.out.println("Smartphone is powered on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is powered off.");
    }

    @Override
    public void connectToInternet() {
        System.out.println("Smartphone connected to the internet.");
    }

    @Override
    public void disconnectFromInternet() {
        System.out.println("Smartphone disconnected from the internet.");
    }
}

// Usage of the interfaces and classes
public class InterfaceExample {
    public static void main(String[] args) {
        // Creating instances of Television and SmartPhone
        Television tv = new Television();
        SmartPhone phone = new SmartPhone();

        // Using methods from ElectronicDevice and DisplayDevice interfaces
        tv.turnOn();
        tv.displayOn();

        // Using methods from ElectronicDevice and InternetEnabledDevice interfaces
        phone.turnOn();
        phone.connectToInternet();

        // Turning off devices
        tv.turnOff();
        tv.displayOff();
        phone.disconnectFromInternet();
        phone.turnOff();
    }
}
