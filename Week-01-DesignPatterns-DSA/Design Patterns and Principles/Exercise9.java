public interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("The light is ON.");
    }

    public void turnOff() {
        System.out.println("The light is OFF.");
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to the remote.");
        }
    }
}

class TestCommandPattern {
    public static void main(String[] args) {
        
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Pressing ON button ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n--- Pressing OFF button ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}