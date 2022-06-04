import finance.FinanceReport;
import finance.Payment;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FinanceReportTest {
    @Test
    public void FinanceReportTest() throws IllegalArgumentException {
        Payment payment = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        String expected = "Автор: Бухгалтер Лена, Дата: 05.04.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n" +
                "Плательщик: noname, Дата: 01.01.1970, Сумма: 0 руб. 0 коп.\n";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void defaultConstructorTest() {
        FinanceReport financeReport = new FinanceReport();
        String expected = "Автор: noname, Дата: 01.01.1970, Количество платежей: 0, Платежи:\n";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void copyTest() {
        Payment payment = new Payment("Иванов Иван Сергеевич", 28, 2, 1999, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);

        FinanceReport financeReportCopy = new FinanceReport(financeReport);
        assertEquals(financeReport.toString(), financeReportCopy.toString());

        financeReport.setPayment(
                new Payment("bshj c c", 1,1, 1980, 1000), 0
        );
        assertNotEquals(financeReport, financeReportCopy);

    }

    @Test
    public void setReportTest() {
        Payment payment = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        //set
        financeReport.setPayment(payment, 1);

        String expected = "Автор: Бухгалтер Лена, Дата: 05.04.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n";
        assertEquals(expected, financeReport.toString());
    }

    @Test
    public void getReportTest() {
        Payment payment = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(payment, 1);
        assertEquals(true, payment.equals(financeReport.getPayment(0)));
    }

    @Test
    public void getQuantityOfReportsTest() {
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        assertEquals(2, financeReport.getQuantityOfReports());
    }
}