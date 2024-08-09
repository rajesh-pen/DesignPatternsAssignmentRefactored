package net.media.training.designpattern.abstractfactory;

public interface MobileFactory {
    Case getCase();
    Screen getScreen();
    Processor getProcessor();
    MotherBoard getMotherBoard();
}
