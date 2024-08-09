package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:27:08 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericEmployee extends CompanyMember {
    private final Validator monthsSpentValidator;
    public GenericEmployee(Validator nameValidator, Validator salaryValidator, Validator monthsSpentValidator) {
        super(nameValidator, salaryValidator);
        this.monthsSpentValidator = monthsSpentValidator;
    }

    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    public void setManagerName(String name) {
        super.setManagerName(name);
        this.mgrName = name;
    }

    public void setMonthsSpent(int months) {
        monthsSpentValidator.validate(months);
    }
}
