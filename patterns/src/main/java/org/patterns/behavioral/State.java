package org.patterns.behavioral;

// State Interface
interface TrafficLightState {
    void handleReq(Context context);
}

// Concrete States
class RedLight implements TrafficLightState {

    @Override
    public void handleReq(Context context) {
        System.out.println("Red Light: Stop");
        context.setTrafficLightState(new GreenLight());
    }
}

class GreenLight implements TrafficLightState {

    @Override
    public void handleReq(Context context) {
        System.out.println("Green Light: Go");
        context.setTrafficLightState(new YellowLight());
    }
}

class YellowLight implements TrafficLightState {


    @Override
    public void handleReq(Context context) {
        System.out.println("Yellow Light: Be Ready to stop");
        context.setTrafficLightState(new RedLight());
    }
}

// Context class
class Context {
    private TrafficLightState trafficLightState;

    public Context(){
       trafficLightState = new RedLight();
    }

    public void setTrafficLightState(TrafficLightState trafficLightState){
        this.trafficLightState = trafficLightState;
    }

    public void changeTrafficLight(){
        trafficLightState.handleReq(this);
    }
}
public class State {
    public static void main(String[] args) {

        Context context = new Context();
        context.changeTrafficLight();
        context.changeTrafficLight();
        context.changeTrafficLight();
        context.changeTrafficLight();
        context.changeTrafficLight();
    }
}
