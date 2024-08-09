package net.media.training.designpattern.abstractfactory;

public class IphoneFactory implements MobileFactory{

    public Case getCase() {
        return new IphoneCase();
    }

    public Screen getScreen() {
        return new IphoneScreen();
    }

    public Processor getProcessor() {
        return new IphoneProcessor();
    }

    public MotherBoard getMotherBoard() {
        return new IphoneMotherBoard();
    }
}
