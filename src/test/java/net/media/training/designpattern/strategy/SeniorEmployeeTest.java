package net.media.training.designpattern.strategy;


import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 20, 2011
 * Time: 6:49:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeniorEmployeeTest {
    SeniorEmployee seniorEmployee = new SeniorEmployee(
            new Validators(new ArrayList<Validator>(){{
                add(new Length(50));
                add(new NotEmpty());
            }}),
            new Validators(new ArrayList<Validator>(){{
                add(new AtLeast(200));
                add(new AtMost(1000));
            }}),
            new AtLeast(60),
            new AtLeast(1)
    );

    @Test
    public void testShortNamesAreAllowed() {
        seniorEmployee.setName("Max Payne");
    }

    @Test(expected = RuntimeException.class)
    public void testNamesAbove50CharsAreNotAllowed() {
        seniorEmployee.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = RuntimeException.class)
    public void testSalaryOf100IsInValid() {
        seniorEmployee.setSalary(100);
    }

    @Test(expected = RuntimeException.class)
    public void testSalaryOf1001IsInvalid() {
        seniorEmployee.setSalary(1001);
    }

    @Test(expected = RuntimeException.class)
    public void testMonthsSpentIsNotNegative() {
        seniorEmployee.setMonthsSpent(-1);
    }

    @Test(expected = RuntimeException.class)
    public void testMonthsSpentCanNotBeLessThan60() {
        seniorEmployee.setMonthsSpent(59);
    }

    @Test(expected = RuntimeException.class)
    public void testBonusIsAtleast1() {
        seniorEmployee.setMaxBonus(0);
    }

    @Test(expected = RuntimeException.class)
    public void testManagerNameIsNotEmpty() {
        seniorEmployee.setManagerName("");
    }
}
