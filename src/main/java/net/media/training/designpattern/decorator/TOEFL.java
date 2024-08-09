package net.media.training.designpattern.decorator;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 10:41:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class TOEFL extends GPAEval {

    private final Criteria preCriteria;

    public TOEFL(Criteria preCriteria) {
        this.preCriteria = preCriteria;
    }

    @Override
    public boolean evaluate(Application theApp) {
        return preCriteria.evaluate(theApp) && theApp.getToefl() > 100;
    }
}
