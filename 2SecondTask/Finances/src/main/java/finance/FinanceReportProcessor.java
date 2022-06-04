package finance;

import java.util.ArrayList;

public class FinanceReportProcessor {


    public static FinanceReport ConfigureByCharReport(FinanceReport financeReport, char c) {
        ArrayList<Payment> list = new ArrayList<>();

        for (int i = 0; i < financeReport.getQuantityOfReports(); i++) {
            if (Character.toLowerCase(financeReport.getPayment(i).getFullName().charAt(0)) == Character.toLowerCase(c)) {
                list.add(financeReport.getPayment(i));

            }
        }
        return new FinanceReport(financeReport, list.toArray(Payment[]::new));
    }


    public static FinanceReport ConfigureBySumReports(FinanceReport financeReport, double a) {
        ArrayList<Payment> list = new ArrayList<>();

        for (int i = 0; i < financeReport.getQuantityOfReports(); i++) {
            if (Double.compare(a, financeReport.getPayment(i).getAmountOfPayment()) > 0) {
                list.add(financeReport.getPayment(i));

            }
        }
        return new FinanceReport(financeReport,list.toArray(Payment[]::new));
    }


}