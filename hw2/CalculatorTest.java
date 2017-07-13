import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /* Do not change this to be private. For silly testing reasons it is public. */
    public Calculator tester;

    /**
     * setUp() performs setup work for your Calculator.  In short, we 
     * initialize the appropriate Calculator for you to work with.
     * By default, we have set up the Staff Calculator for you to test your 
     * tests.  To use your unit tests for your own implementation, comment 
     * out the StaffCalculator() line and uncomment the Calculator() line.
     **/
    @Before
    public void setUp() {
        //tester = new StaffCalculator(); // Comment me out to test your Calculator
        tester = new Calculator();   // Un-comment me to test your Calculator
    }

    // TASK 1: WRITE JUNIT TESTS
    // YOUR CODE HERE

    @Test
    public void calculatorTest1() {
    	int a = 5;
    	int b = 10;
    	int c = tester.multiply(a, b);

    	assertEquals(50, c);
    }

    @Test
    public void calculatorTest2() {
    	int a = -5;
    	int b = 10;
    	int c = tester.multiply(a, b);

    	assertEquals(-50, c);
    }

    @Test
    public void calculatorTest3() {
    	int a = -5;
    	int b = -5;
    	int c = tester.multiply(a, b);

    	assertEquals(25, c);
    }

    @Test
    public void calculatorTest4() {
    	int a = 0;
    	int b = -1;
    	int c = tester.multiply(a, b);

    	assertEquals(0, c);
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        jh61b.junit.textui.runClasses(CalculatorTest.class);
    }       
}