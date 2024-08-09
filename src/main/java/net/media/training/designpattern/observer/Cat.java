package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:13:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cat implements SunSubscriber{
    private final Sun sun;
    private boolean outdoors;
    private boolean feelingWarm;
    private boolean feelingTired;

    public Cat(Sun sun){
        this.sun = sun;
    }

    public boolean isFeelingWarm() {
        return feelingWarm;
    }

    public void goOutdoors() {
        outdoors = true;
        feelingWarm = sun.isUp();
        sun.subscribe(this);
    }

    public void goIndoors() {
        outdoors = false;
        sun.unSubscribe(this);
    }

    public boolean isOutdoors() {
        return outdoors;
    }

    public void notifySunRose() {
        feelingWarm = true;
    }

    public void notifySunSet() {
        feelingWarm = false;
        feelingTired = true;
    }

    public boolean isFeelingTired() {
        return feelingTired;
    }
}
