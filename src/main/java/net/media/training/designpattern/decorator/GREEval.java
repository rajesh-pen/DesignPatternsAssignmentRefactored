package net.media.training.designpattern.decorator;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 10:28:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class GREEval implements Criteria {

    private final Criteria preCriteria;

    public GREEval(Criteria preCriteria) {
        this.preCriteria = preCriteria;
    }

    @Override
    public boolean evaluate(Application theApp) {
        if (preCriteria.evaluate(theApp)) {
            System.out.println("GREEval called");
            return theApp.getGre() > 1450;
        } else {
            return false;
        }
    }
}
