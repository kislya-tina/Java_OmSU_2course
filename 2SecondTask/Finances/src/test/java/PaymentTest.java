import static org.testng.Assert.assertEquals;

import finance.Payment;
import org.testng.annotations.Test;

public class PaymentTest {
    @Test
    public void defaultConstructorTest() {
        Payment a = new Payment();
        assertEquals("Плательщик: noname, Дата: 00.00.0000, Сумма: 0 руб. 0 коп.\n", a.toString());
    }

    @Test
    public void copyTest() throws IllegalArgumentException {
        Payment a = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 20);
        Payment b = new Payment(a);
        assertEquals(true, a.equals(b));

    }

    @Test
    public void equalsTest() throws IllegalArgumentException {
        Payment a = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 20);
        Payment b = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 20);
        assertEquals(true, a.equals(b));

    }

    @Test
    public void toStringTest() throws IllegalArgumentException {
        Payment a = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        assertEquals("Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n", a.toString());

    }

    @Test
    public void hashCodeTest() {
        Payment a = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        assertEquals(-366877990, a.hashCode());
    }


}