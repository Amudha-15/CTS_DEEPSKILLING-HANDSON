interface Command { void execute(); }

class Light {
    public void on(){ System.out.println("Light is ON"); }
    public void off(){ System.out.println("Light is OFF"); }
}

class LightOnCommand implements Command {
    private final Light light; LightOnCommand(Light l){ this.light = l; }
    public void execute(){ light.on(); }
}
class LightOffCommand implements Command {
    private final Light light; LightOffCommand(Light l){ this.light = l; }
    public void execute(){ light.off(); }
}

class RemoteControl {
    private Command slot;
    public void setCommand(Command c){ slot = c; }
    public void pressButton(){ if (slot != null) slot.execute(); }
}

public class CommandDemo {
    public static void main(String[] args){
        Light light = new Light();
        RemoteControl rc = new RemoteControl();
        rc.setCommand(new LightOnCommand(light)); rc.pressButton();
        rc.setCommand(new LightOffCommand(light)); rc.pressButton();
    }
}
