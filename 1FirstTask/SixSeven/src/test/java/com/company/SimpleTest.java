package com.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.company.Main.seventhTask;
import static com.company.Main.sixTask;
import static org.testng.Assert.assertEquals;

public class SimpleTest {




    @DataProvider
    public static Object[][] seven() {
        return new Object[][]{
                {0.0, 1e-10, Math.exp(0.0)},
                {2.0, 1e-10, Math.exp(2.0)},
                {-2.0, 1e-10, Math.exp(-2.0)}
        };
    }


    @Test(dataProvider = "seven")
    public void testSeven(double x, double eps, double expected) {
        double actual = seventhTask(x, eps);
        assertEquals(actual, expected, eps);
    }


    @Test
    public void testSixth() {
        sixTask(0, 0, 0, 0, 0, 0);
        System.out.println();

        sixTask(0, 0, 1, 0, 0, 0);
        sixTask(0, 0, 0, 0, 0, 1);
        sixTask(1, 2, 3, 0, 0, 1);
        sixTask(1, 0, 3, 2, 0, 7);
        sixTask(0, 2, 3, 0, 5, 7);
        sixTask(1, 2, 3, 2, 4, 7);
        System.out.println();

        sixTask(1, 2, 3, 0, 0, 0);
        sixTask(1, 2, 3, 2, 4, 6);
        sixTask(0, 2, 3, 0, 4, 6);
        sixTask(1, 0, 3, 2, 0, 6);
        System.out.println();

        assertEquals(sixTask(1, 2, 3, 4, 5, 6), new double[]{-1.0, 2.0});

    }



}