import java.util.Objects;

public class TurnOnLightCommand implements Command {

    private final Light light;

    public TurnOnLightCommand(Light light) {
        this.light = Objects.requireNonNull(light, "light must not be null");
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
