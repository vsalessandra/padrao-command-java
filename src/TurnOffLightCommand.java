import java.util.Objects;

public class TurnOffLightCommand implements Command {

    private final Light light;

    public TurnOffLightCommand(Light light) {
        this.light = Objects.requireNonNull(light, "light must not be null");
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
