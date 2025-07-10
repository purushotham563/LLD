package ElevatorSystem;

public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3, 10, 10);
        controller.start();

        try {
            // User at floor 3 presses UP
            controller.requestElevator(3, Direction.UP);
            Thread.sleep(2000);

            // User inside elevator 1 selects floor 7
            controller.addDestination(1, 7);

            // User at floor 5 presses DOWN
            Thread.sleep(3000);
            controller.requestElevator(5, Direction.DOWN);

            // Undo the last command (floor 5 DOWN request)
            Thread.sleep(2000);
            controller.undoLastCommand();

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            controller.shutdown();
        }
    }
}
