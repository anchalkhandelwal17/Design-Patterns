package org.patterns.structural;

//The Adapter Pattern is a structural design pattern that allows
//two incompatible interfaces to work together.
//It acts as a middle-layer "wrapper" or translator between your main application (the client)
//and an existing third-party library, legacy codebase, or service that has a different,
//incompatible structure.

// Target Interface
interface iphoneCharger {
    void chargeIphone();
}

// Adaptee
class AndroidCharger {

    public void chargeAndroid(){
        System.out.println("Charging Android Phone..");
    }
}

// Adapter Class
class IphoneAdapter implements iphoneCharger {
    private AndroidCharger androidCharger;

    public IphoneAdapter(AndroidCharger androidCharger){
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeIphone() {
        androidCharger.chargeAndroid();
    }
}

public class Adapter {
    public static void main(String[] args) {

        AndroidCharger androidCharger = new AndroidCharger();

        IphoneAdapter iphoneAdapter = new IphoneAdapter(androidCharger);
        iphoneAdapter.chargeIphone();
    }
}
