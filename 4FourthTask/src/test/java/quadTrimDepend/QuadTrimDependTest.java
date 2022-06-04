package quadTrimDepend;

import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class QuadTrimDependTest {
    QuadTrimDepend first = new QuadTrimDepend(1, 2, 1);
    QuadTrimDepend second = new QuadTrimDepend(2, -7, 3);
    QuadTrimDepend third = new QuadTrimDepend(2, 2, 2);


    @Test
    public void FirstTest(){
        double answer = -1;
        assertEquals(first.higherDecision(), answer);
    }

    @Test
    public void higherDecision(){
        double answer = 3;
        assertEquals(second.higherDecision(), answer);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void ThirdTest(){
        double answer = 7;
        assertEquals(third.higherDecision(), answer);
    }
}
