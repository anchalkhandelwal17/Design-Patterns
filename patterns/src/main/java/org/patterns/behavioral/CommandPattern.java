package org.patterns.behavioral;

import java.util.List;

interface Command {
    void execute();
}

// Receiver
class Fan {

    public void turnOn(){
        System.out.println("Fan turned on.");
    }
}

// Receiver
class Light {

    public void turnOn(){
        System.out.println("Light turned on");
    }
}

// Concrete Commands
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Commands
class FanOnCommand implements Command {

    private Fan fan;

    public FanOnCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }
}

// Invoker
class RemoteControl {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        FanOnCommand fanOnCommand = new FanOnCommand(fan);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(fanOnCommand);
        remoteControl.pressButton();
    }
}
