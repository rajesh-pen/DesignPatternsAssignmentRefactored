package net.media.training.designpattern.strategy;

public class NotEmpty implements Validator{

    @Override
    public void validate(Object entry) {
        String str = (String) entry;
        if (str == null || str.length() == 0)
            throw new RuntimeException("not empty check failed for value:" + str);
    }
}
