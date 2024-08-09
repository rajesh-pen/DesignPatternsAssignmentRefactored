package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {

    public Case buildPhone(String phoneType) {
        MobileFactory mobileFactory;

        if(phoneType.equals("Android")){
            mobileFactory = new AndroidFactory();
        }else{
            mobileFactory = new IphoneFactory();
        }

        MotherBoard motherBoard = mobileFactory.getMotherBoard();
        Processor processor =  mobileFactory.getProcessor();
        motherBoard.attachBattery(new Battery());
        motherBoard.attachProcessor(processor);

        Screen screen = mobileFactory.getScreen();

        Case phoneCase = mobileFactory.getCase();
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);

        return phoneCase;
    }
}
