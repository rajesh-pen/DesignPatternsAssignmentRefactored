package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 21, 2011
 * Time: 9:06:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class SunTestClient {
    private final Person person;
    private final Cat cat;
    private final Dog dog;
    private final Robot robot;

    private boolean personWentOut = false;
    private boolean robotWentOut = false;
    private boolean catWentOut;
    private boolean dogWentOut;
    private Sun sun;

    public SunTestClient() {
        this.sun = new Sun();
        this.person = new Person(sun);
        this.dog = new Dog(sun);
        this.cat = new Cat(sun);
        this.robot = new Robot(sun);
    }

    public void aFewCharactersGoOutdoors() {
        person.goOutdoors();
        robot.goOutdoors();
        personWentOut = true;
        robotWentOut = true;
    }

    public void aFewOtherCharactersGoOutdoors() {
        cat.goOutdoors();
        dog.goOutdoors();
        catWentOut = true;
        dogWentOut = true;
    }

    public void sunRise() {
        sun.rise();
    }

    public void sunSet() {
        sun.set();
    }

    public boolean charactersWhoWereOutAreFeelTired() {
        if (person.isOutdoors() && !person.isFeelingTired())
            return false;
        if (robot.isOutdoors() && !robot.isFeelingTired())
            return false;
        if (cat.isOutdoors() && !cat.isFeelingTired())
            return false;
        return !dog.isOutdoors() || dog.isFeelingTired();
    }

    public boolean outdoorsCharactersFeelWarm() {
        if (person.isOutdoors() && !person.isFeelingWarm())
            return false;
        if (cat.isOutdoors() && !cat.isFeelingWarm())
            return false;
        if (dog.isOutdoors() && !dog.isFeelingWarm())
            return false;
        if (robot.isOutdoors() && !robot.isFeelingWarm())
            return false;

        if (!person.isOutdoors() && person.isFeelingWarm())
            return false;
        if (!cat.isOutdoors() && cat.isFeelingWarm())
            return false;
        if (!dog.isOutdoors() && dog.isFeelingWarm())
            return false;
        if (!robot.isOutdoors() && robot.isFeelingWarm())
            return false;

        return true;
    }
}
