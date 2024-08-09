package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:31:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee extends GenericEmployee {
    private final Validator maxAllowedLeavesValidator;
    private int maxAllowedLeaves;

    public Employee(Validator nameValidator, Validator salaryValidator, Validator monthsSpentValidator, Validator maxAllowedLeavesValidator) {
        super(nameValidator, salaryValidator, monthsSpentValidator);
        this.maxAllowedLeavesValidator = maxAllowedLeavesValidator;
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

    public void setMaxAllowedLeaves(int leaves) {
        maxAllowedLeavesValidator.validate(leaves);
        this.maxAllowedLeaves = leaves;
    }
}

