package net.media.training.designpattern.strategy;

public class Length implements Validator{
    private final int maxLength;

    public Length(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void validate(Object entry) {
        String str = (String) entry;
        if (str.length() > maxLength)
            throw new RuntimeException("Invalid length:" + str.length());
    }
}
