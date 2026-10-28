# Código antigo (antes do padrão Command)

Versão original do sistema de controle de iluminação, mantida aqui como referência.

## Light.java

```java
public class Light {

    private String location;
    private boolean on;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        on = true;
        System.out.println(location + ": light on");
    }

    public void turnOff() {
        on = false;
        System.out.println(location + ": light off");
    }

    public boolean isOn() {
        return on;
    }
}
```

## RemoteControl.java

```java
public class RemoteControl {

    private Light light;

    public RemoteControl(Light light) {
        this.light = light;
    }

    public void pressButton(String action) {
        if ("ON".equals(action)) {
            light.turnOn();
        } else if ("OFF".equals(action)) {
            light.turnOff();
        } else {
            System.out.println("Unknown action");
        }
    }
}
```

## Main.java

```java
public class Main {

    public static void main(String[] args) {

        Light light = new Light("Living room");
        RemoteControl remote = new RemoteControl(light);

        remote.pressButton("ON");
        remote.pressButton("OFF");
    }
}
```

## Problemas

- `RemoteControl` depende diretamente de `Light` e conhece as operações do dispositivo.
- Novas ações ou dispositivos exigem alterar as condicionais (`if/else`) do controle.
- A solicitação é apenas um texto (`"ON"`, `"OFF"`), sem um objeto que reúna a operação e o destinatário.
- Não é possível reconfigurar botões nem reutilizar a estrutura de acionamento para outros comportamentos.
