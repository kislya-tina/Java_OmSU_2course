import static org.testng.Assert.assertEquals;

import finance.FinanceReport;
import finance.FinanceReportProcessor;
import finance.Payment;
import org.testng.annotations.Test;


public class FinanceReportProcessorTest {
    @Test
    public void byCharTest() {
        Payment payment = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        String expected = "Автор: noname, Дата: 00.00.0000, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n";
        assertEquals(expected, FinanceReportProcessor.ConfigureByCharReport(financeReport, 'и').toString());
    }

    @Test
    public void bySumTest() {
        Payment payment = new Payment("Иванов Иван Сергеевич", 11, 11, 1999, 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        int sum=20;
        String expected="Автор: noname, Дата: 00.00.0000, Количество платежей: 2, Платежи:\n" +
                "Плательщик: noname, Дата: 00.00.0000, Сумма: 0 руб. 0 коп.\n";
        assertEquals(expected,FinanceReportProcessor.ConfigureBySumReports(financeReport,sum).toString());
    }
}