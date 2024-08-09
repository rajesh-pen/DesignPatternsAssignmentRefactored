package net.media.training.designpattern.strategy;

import java.util.List;

public class Validators implements Validator{
    private List<Validator> validatorList;

    public Validators(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    @Override
    public void validate(Object entry) {
        for (Validator validator: validatorList){
            validator.validate(entry);
        }
    }
}
