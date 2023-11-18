// TrafficLightExample.java
public class TrafficLightExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        for (int i = 0; i < 10; i++) {
            System.out.println("Current state: " + trafficLight.getCurrentState().name());
            System.out.println("Description: " + trafficLight.getCurrentState().getDescription());
            System.out.println("Duration: " + trafficLight.getCurrentState().getDurationSeconds() + " seconds\n");

            trafficLight.advance();
        }
    }
}

// TrafficLight.java
enum TrafficLightState {
    RED("Stop", 30),
    YELLOW("Prepare to Go", 5),
    GREEN("Go", 30);

    private final String description;
    private final int durationSeconds;

    TrafficLightState(String description, int durationSeconds) {
        this.description = description;
        this.durationSeconds = durationSeconds;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }
}

class TrafficLight {
    private TrafficLightState currentState;

    public TrafficLight() {
        currentState = TrafficLightState.RED; // Initial state
    }

    public void advance() {
        switch (currentState) {
            case RED:
                currentState = TrafficLightState.GREEN;
                break;
            case YELLOW:
                currentState = TrafficLightState.RED;
                break;
            case GREEN:
                currentState = TrafficLightState.YELLOW;
                break;
        }
    }

    public TrafficLightState getCurrentState() {
        return currentState;
    }
}
