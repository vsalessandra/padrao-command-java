public class Main {

    public static void main(String[] args) {

        Light livingRoom = new Light("Living room");
        Light kitchen = new Light("Kitchen");

        RemoteControl remote = new RemoteControl();
        remote.setCommand("A", new TurnOnLightCommand(livingRoom));
        remote.setCommand("B", new TurnOffLightCommand(livingRoom));
        remote.setCommand("C", new TurnOnLightCommand(kitchen));

        System.out.println("--- Pressing configured buttons ---");
        remote.pressButton("A");
        remote.pressButton("B");
        remote.pressButton("C");
        printStates(livingRoom, kitchen);

        System.out.println("--- Reconfiguring button A to turn off the kitchen ---");
        remote.setCommand("A", new TurnOffLightCommand(kitchen));
        remote.pressButton("A");
        printStates(livingRoom, kitchen);

        System.out.println("--- Pressing an unconfigured button ---");
        remote.pressButton("Z");
    }

    private static void printStates(Light... lights) {
        for (Light light : lights) {
            System.out.println(light.getLocation() + " is " + (light.isOn() ? "ON" : "OFF"));
        }
    }
}
