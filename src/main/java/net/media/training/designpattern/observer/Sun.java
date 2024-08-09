package net.media.training.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun {
    private boolean isUp;
    private List<SunSubscriber> subscriberList = new ArrayList<SunSubscriber>();
    public boolean isUp() {
        return isUp;
    }

    public void subscribe(SunSubscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void unSubscribe(SunSubscriber subscriber){
        if(subscriberList.contains(subscriber)){
            subscriberList.remove(subscriber);
        }
    }

    public void set() {
        isUp = false;
        for(SunSubscriber subscriber: subscriberList){
            subscriber.notifySunSet();
        }
    }

    public void rise() {
        isUp = true;
        for(SunSubscriber subscriber: subscriberList){
            subscriber.notifySunRose();
        }
    }
}