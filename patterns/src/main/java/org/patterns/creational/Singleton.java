package org.patterns.creational;

// Only a single instance of this class can be created and that weill be used everywhere
public class Singleton {
    private volatile static Singleton instance;

    private Singleton(){
        if(instance == null){
            throw new RuntimeException("please call getInstance()");
        }
    }

//    public static Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // thread safe
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }
}
