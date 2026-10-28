import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoteControl {

    private final Map<String, Command> commands = new HashMap<>();

    public void setCommand(String button, Command command) {
        if (button == null || button.isBlank()) {
            throw new IllegalArgumentException("button name must not be null or empty");
        }
        Objects.requireNonNull(command, "command must not be null");
        commands.put(button, command);
    }

    public void pressButton(String button) {
        Command command = commands.get(button);
        if (command == null) {
            System.out.println("Warning: button '" + button + "' is not configured");
            return;
        }
        command.execute();
    }
}
