package org.patterns.structural;

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
