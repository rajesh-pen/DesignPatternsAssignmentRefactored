package net.media.training.designpattern.strategy;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 20, 2011
 * Time: 6:17:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeTest {
    Employee employee = new Employee(
            new Validators(new ArrayList<Validator>(){{
                add(new Length(50));
                add(new NotEmpty());
            }}),
            new Validators(new ArrayList<Validator>(){{
                add(new AtLeast(1));
                add(new AtMost(1000));
            }}),
            new AtLeast(0),
            new AtLeast(1)
    );

    @Test
    public void testShortNamesAreAllowed() {
        employee.setName("Max Payne");
    }

    @Test(expected = RuntimeException.class)
    public void testNamesAbove50CharsAreNotAllowed() {
        employee.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = RuntimeException.class)
    public void testSalaryOf0IsInvalid() {
        employee.setSalary(0);
    }

    @Test
    public void testSalaryOf100IsValid() {
        employee.setSalary(100);
    }

    @Test(expected = RuntimeException.class)
    public void testSalaryOf1001IsInvalid() {
        employee.setSalary(1001);
    }

    @Test(expected = RuntimeException.class)
    public void testMonthsSpentIsNotNegative() {
        employee.setMonthsSpent(-1);
    }

    @Test
    public void testMonthsSpentCanBe1() {
        employee.setMonthsSpent(1);
    }

    @Test(expected = RuntimeException.class)
    public void testMaxAllowedLeavesIsAtleast1() {
        employee.setMaxAllowedLeaves(0);
    }

    @Test(expected = RuntimeException.class)
    public void testManagerNameIsNotEmpty() {
        employee.setManagerName("");
    }
}
