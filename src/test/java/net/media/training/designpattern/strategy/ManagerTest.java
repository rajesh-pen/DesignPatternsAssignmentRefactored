package net.media.training.designpattern.strategy;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 20, 2011
 * Time: 9:14:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManagerTest {
    Manager manager = new Manager(
            new Length(50),
            new AtLeast(1),
            new NotEmpty()
    );

    @Test
    public void testShortNamesAreAllowed() {
        manager.setName("Max Payne");
    }

    @Test(expected = RuntimeException.class)
    public void testNamesAbove50CharsAreNotAllowed() {
        manager.setName("pneumonoultramicroscopicsilicovolcanokoniosis smith");
    }

    @Test(expected = RuntimeException.class)
    public void testSalaryOf0IsInvalid() {
        manager.setSalary(0);
    }

    @Test
    public void testSalaryOf100IsValid() {
        manager.setSalary(100);
    }

    @Test
    public void testSalaryOf1001IsValid() {
        manager.setSalary(1001);
    }

    @Test
    public void testMonthsSpentCanBe1() {
        manager.setMonthsSpent(1);
    }

    @Test(expected = RuntimeException.class)
    public void testManagementBandIsNotEmpty() {
        manager.setManagementBand("");
    }

}
