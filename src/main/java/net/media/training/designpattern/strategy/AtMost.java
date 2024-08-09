package net.media.training.designpattern.strategy;

public class AtMost implements Validator{
    private final int maxVal;

    public AtMost(int maxVal) {
        this.maxVal = maxVal;
    }

    @Override
    public void validate(Object entry) {
        if ((int) entry > maxVal)
            throw new RuntimeException("at least check failed:" + entry);
    }
}
