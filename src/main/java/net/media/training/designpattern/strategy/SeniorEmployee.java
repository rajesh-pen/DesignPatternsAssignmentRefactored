package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:35:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeniorEmployee extends GenericEmployee {
    private final Validator maxBonusValidator;
    private int setMaxBonus;

    public SeniorEmployee(Validator nameValidator, Validator salaryValidator, Validator monthsSpentValidator, Validator maxBonusValidator) {
        super(nameValidator, salaryValidator, monthsSpentValidator);
        this.maxBonusValidator = maxBonusValidator;
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
        this.salary = salary;
    }

    @Override
    public void setMonthsSpent(int months) {
        super.setMonthsSpent(months);
        this.monthsSpent = months;
    }

    public void setMaxBonus(int bonus) {
        maxBonusValidator.validate(bonus);
        this.setMaxBonus = bonus;
    }
}
