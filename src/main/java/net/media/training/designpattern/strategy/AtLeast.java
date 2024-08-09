package net.media.training.designpattern.strategy;

public class AtLeast implements Validator{
    private final int minVal;

    public AtLeast(int minVal) {
        this.minVal = minVal;
    }

    @Override
    public void validate(Object entry) {
        if ((int) entry < minVal)
            throw new RuntimeException("at least check failed:" + entry);
    }
}
