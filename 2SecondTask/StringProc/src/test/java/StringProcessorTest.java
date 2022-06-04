import StringClasses.StringProcessor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static StringClasses.StringProcessor.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class StringProcessorTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"N", 3, "NNN"},
                {"qwe", 3, "qweqweqwe"},
                {"", 3, ""},
                {"", 0, ""},
                {"as", 0, ""}
        };
    }

    @DataProvider
    public static Object[][] countData() {
        return new Object[][]{
                {"a", "a", 1},
                {"aa", "a", 2},
                {"aaa", "aa", 2},

                {"aaaa", "vvv", 0},
                {"aeqra facwda", "a", 4}
        };
    }

    @DataProvider
    public static Object[][] onetwothreeData() {
        return new Object[][]{
                {"", ""},
                {"567890", "567890"},
                {" 1 ", " один "},
                {" 2", " два"},
                {"1 2 3", "один два три"}
        };
    }




    @Test(dataProvider = "data")
    public void testCopy(String str, int N, String expected) throws IllegalArgumentException {
        assertEquals(CopyString(str, N), expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testCopyExc() throws IllegalArgumentException {
        CopyString("qwe", -6);
        fail();
    }

    @Test(dataProvider = "countData")
    public void testFind(String big, String small, int expected) {
        assertEquals(CountEnter(big, small), expected);
    }
    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void testFindPoop(){
        String big = "asdfa";
        String small = "";
        int expected = -1;
        assertEquals(CountEnter(big, small), expected);
    }

    @Test(dataProvider = "onetwothreeData")
    public void testChange(String source, String expected) {
        assertEquals(ReplaceStr(source), expected);
    }

    @Test
    public void testChange2() {
        StringBuilder  stringBuilder = new StringBuilder("1234567");
        StringBuilder temp = StringProcessor.deleteSymbol(stringBuilder);
        assertEquals(temp.toString(), "1357");
        temp = StringProcessor.deleteSymbol(temp);
        assertEquals(temp.toString(), "15");
        temp = StringProcessor.deleteSymbol(temp);
        assertEquals(temp.toString(), "1");
        temp = StringProcessor.deleteSymbol(temp);
        assertEquals(temp.toString(), "1");
    }






}