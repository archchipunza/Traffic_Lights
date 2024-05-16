// Enum class representing the traffic light colors
enum TrafficLightColor {
    RED, YELLOW, GREEN
}

// Simulation class for automatic traffic lights
class TrafficLightSimulator {
    public TrafficLightColor currentColor;

    public TrafficLightSimulator(TrafficLightColor initialColor) {
        this.currentColor = initialColor;
    }

    // Method to change the traffic light color based on the current color
    public void changeColor(TrafficLightColor currentColor) {
        switch (currentColor) {
            case RED:
                this.currentColor = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                this.currentColor = TrafficLightColor.RED;
                break;
            case GREEN:
                this.currentColor = TrafficLightColor.YELLOW;
                break;
            default:
                System.out.println("Invalid traffic light color.");
        }
    }

    // Overriding toString method to just return the current traffic light color
    @Override
    public String toString() {
        return this.currentColor.toString();
    }
}

// Main class to create the simulator object and run the simulation continuously
public class Main {
    public static void main(String[] args) {
        TrafficLightSimulator simulator = new TrafficLightSimulator(TrafficLightColor.RED);

        // Continuous simulation of traffic light changing colors
        while (true) {
            System.out.println(simulator); // Print current color before changing
            simulator.changeColor(simulator.currentColor); // Change color
            try {
                Thread.sleep(2000); // Delay for 2 seconds between color changes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}