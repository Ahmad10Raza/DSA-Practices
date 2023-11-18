 public class EnumTypesExample {
    // Enum type representing the states of a traffic light
    enum TrafficLightState {
        RED("Stop", 30),
        YELLOW("Prepare to Go", 5),
        GREEN("Go", 30);

        private final String description;
        private final int durationSeconds;

        // Constructor
        TrafficLightState(String description, int durationSeconds) {
            this.description = description;
            this.durationSeconds = durationSeconds;
        }

        // Getter methods
        public String getDescription() {
            return description;
        }

        public int getDurationSeconds() {
            return durationSeconds;
        }
    }

    // Class representing a traffic light
    static class TrafficLight {
        private TrafficLightState currentState;

        // Constructor
        public TrafficLight() {
            currentState = TrafficLightState.RED; // Initial state
        }

        // Method to advance to the next state
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

        // Getter method for the current state
        public TrafficLightState getCurrentState() {
            return currentState;
        }
    }

    // Entry point for the Java application
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
