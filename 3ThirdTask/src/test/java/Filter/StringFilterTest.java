package Filter;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class StringFilterTest {

    @Test
    public void BeginStringFilterTest() {
        String str = "Мама мыла раму";
        BeginStringFilter filter1 = new BeginStringFilter("Мама");
        BeginStringFilter filter2 = new BeginStringFilter("мыла");
        boolean res1 = filter1.apply(str); // результат true
        boolean res2 = filter2.apply(str); // результат false
        assertNotEquals(res1, res2);
    }

    @Test
    public void EndStringFilterTest() {
        String str = "Мама мыла раму";
        EndStringFilter filter1 = new EndStringFilter("раму");
        EndStringFilter filter2 = new EndStringFilter("мыла");
        boolean res1 = filter1.apply(str); // результат true
        boolean res2 = filter2.apply(str); // результат false
        assertNotEquals(res1, res2);
    }

    @Test
    public void ContainsStringFilterTest() {
        String str = "Мама мыла раму";
        ContainsStringFilter filter1 = new ContainsStringFilter("Мама");
        ContainsStringFilter filter2 = new ContainsStringFilter("Папа");
        boolean res1 = filter1.apply(str); // результат true
        boolean res2 = filter2.apply(str); // результат false
        assertNotEquals(res1, res2);
    }
}