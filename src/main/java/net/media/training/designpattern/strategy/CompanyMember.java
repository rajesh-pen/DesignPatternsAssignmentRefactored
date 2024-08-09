package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:14:31 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompanyMember {
    private String name;
    protected String mgrName;
    protected int salary;
    protected int monthsSpent;
    private final Validator nameValidator;
    private final Validator salaryValidator;

    public CompanyMember(Validator nameValidator, Validator salaryValidator) {
        this.nameValidator = nameValidator;
        this.salaryValidator = salaryValidator;
    }

    public void setName(String name) {
        this.nameValidator.validate(name);
        this.name = name;
    }

    public void setSalary(int salary) {
        salaryValidator.validate(salary);
    }

    public void setManagerName(String name) {
        this.nameValidator.validate(name);
    }
}
