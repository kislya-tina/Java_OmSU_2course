package functionals;

import functionals.functionsOfSingleArgument.*;
import functionals.functional.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FunctionsTests {
    @DataProvider
    public static Object[][] ExceptionsIORAFData() {
        return new Object[][]{
                {new LinearFunc(2, 2, 0, 10)},
                {new SinFunc(2, 2, 0, 10)},
                {new RationalFunc(1, 2, 3, 4, 0, 10)},
                {new ExpFunc(1, 2, 0, 10)}
        };
    }
    @DataProvider
    public static Object[][] ExceptionsFunctionalData() {
        return new Object[][]{
                {new SumFunctional(-1, 10, 100)},
                {new IntegralFunctional(0, 20, 100)}
        };
    }
    @Test (dataProvider = "ExceptionsIORAFData", expectedExceptions = {IllegalArgumentException.class})
    public void ExceptionsIORAFTest (IFuncOnSegment func){
        func.getValue(-1);
    }
    @Test (dataProvider = "ExceptionsFunctionalData", expectedExceptions = {IllegalArgumentException.class})
    public void ExceptionsFunctionalTest (IFunctional<LinearFunc> func){
        LinearFunc linearFunc = new LinearFunc(2, 2, 0, 10);
        func.getValue(linearFunc);
    }
    @Test
    public void LinearFunctionTest() {
        LinearFunc linearFunction = new LinearFunc(2, 2, 0, 10);
        assertEquals(linearFunction.getValue(5), 12, 0.001);
    }
    @Test
    public void SinFunctionTest() {
        SinFunc sinFunction = new SinFunc(2, 2, 0, 10);
        assertEquals(sinFunction.getValue(5), -1.088, 0.001);
    }
    @Test
    public void RationalFunctionTest() {
        RationalFunc rationalFunction = new RationalFunc(1, 2, 3, 4, 0, 10);
        assertEquals(rationalFunction.getValue(5), 0.368, 0.001);
    }
    @Test
    public void ExpFunctionTest() {
        ExpFunc expFunction = new ExpFunc(1, 2, 0, 10);
        assertEquals(expFunction.getValue(5), 150.413, 0.001);
    }
    @Test
    public void SumFunctionalTest() {
        LinearFunc linearFunc = new LinearFunc(1,2,0,10);
        SumFunctional<LinearFunc> sumFunctional = new SumFunctional<> (0, 10, 100);
        assertEquals(sumFunctional.getValue(linearFunc), 21, 0.001);
    }
    @Test
    public void IntegralFunctionalTest() {
        LinearFunc linearFunction = new LinearFunc(1,2,0,10);
        IntegralFunctional integralFunctional = new IntegralFunctional(0, 10, 100);
        assertEquals(integralFunctional.getValue(linearFunction), 70, 0.001);
    }
}