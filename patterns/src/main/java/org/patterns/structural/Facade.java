package org.patterns.structural;

class DVDPlayer {

    public void on(){
        System.out.println("DVD Player turned on.");
    }

    public void playMovie(){
        System.out.println("Playing Movie");
    }
}

class Projector {

    public void on(){
        System.out.println("Projector turned on");
    }
}

class Lights {
    public void dim(){
        System.out.println("Lights Dimmed");
    }
}

class SoundSystem {
    public void on(){
        System.out.println("Sound System on");
    }

    public void setVolume(int volume){
        System.out.println("Volume set to: " + volume);
    }
}

// Facade simplifying the complexity
class HomeTheatreFacade {

    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;
    private SoundSystem soundSystem;

    public HomeTheatreFacade(DVDPlayer dvdPlayer, Projector projector,
                             Lights lights, SoundSystem soundSystem){
        this.dvdPlayer = dvdPlayer;
        this.lights = lights;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(){
        lights.dim();
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(40);
        dvdPlayer.on();
        dvdPlayer.playMovie();
    }
}

public class Facade {
    public static void main(String[] args) {

        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(dvdPlayer,
                projector, lights, soundSystem);

        homeTheatreFacade.watchMovie();
    }
}
