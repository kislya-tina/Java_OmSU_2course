package quadraticTrinominal;

import org.testng.annotations.Test;
import quadraticTrinominal.QuadraticTrinominal;

import static org.testng.Assert.assertEquals;

public class QuadraticTrinominalTest {
    QuadraticTrinominal first = new QuadraticTrinominal(1, 2, 1);
    QuadraticTrinominal fourth = new QuadraticTrinominal(2, -7, 3);

    @Test
    public void FirstTest(){
        double[] answer = {-1};
        assertEquals(first.decision(), answer);
    }

    @Test (expectedExceptions = {IllegalArgumentException.class})
    public void SecondTest(){
        QuadraticTrinominal second = new QuadraticTrinominal(0, -2, 1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void ThirdTest(){
        QuadraticTrinominal third = new QuadraticTrinominal(2, 2, 2);
        double[] answer = {0};
        assertEquals(third.decision(), answer);
    }

    @Test
    public void FourthTest(){
        double[] answer = {3, 0.5};
        assertEquals(fourth.decision(), answer);
    }
}
