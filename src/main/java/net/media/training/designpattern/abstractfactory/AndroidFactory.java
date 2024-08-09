package net.media.training.designpattern.abstractfactory;

public class AndroidFactory implements MobileFactory{

    public Case getCase() {
        return new AndroidCase();
    }

    public Screen getScreen() {
        return new AndroidScreen();
    }

    public Processor getProcessor() {
        return new AndroidProcessor();
    }

    public MotherBoard getMotherBoard() {
        return new AndroidMotherBoard();
    }
}
