package finance;

import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {


    private String author;
    private Date date;
    private int quantityOfReports;
    private Payment[] payments;

    //конструкторы
    public FinanceReport(int quantityOfReports, int day, int month, int year, String author) {
        if(author == null || author.isEmpty()) throw new IllegalArgumentException();
        this.quantityOfReports = quantityOfReports;
        payments = new Payment[quantityOfReports];
        this.date = new Date(day, month, year);
        this.author = author;
    }

    public FinanceReport( String author, Payment... payments) {
        if(author == null || author.isEmpty()) throw new IllegalArgumentException();
        this.quantityOfReports = payments.length;
        this.payments = payments;
        this.date = new Date();
        this.author = author;
    }

    public FinanceReport( String author, int day, int month, int year, Payment... payments) {
        if(author == null || author.isEmpty()) throw new IllegalArgumentException();
        this.quantityOfReports = payments.length;
        this.payments = payments;
        this.date = new Date(day, month, year);
        this.author = author;
    }

    public FinanceReport() {
        this.quantityOfReports = 0;
        payments = new Payment[quantityOfReports];
        this.date = new Date();
        this.author = "noname";
    }

    public FinanceReport(FinanceReport f) {
        this.quantityOfReports = f.getQuantityOfReports();
        // TODO: 3/17/2022
        this.payments = new Payment[f.payments.length];
        for (int i = 0; i < f.payments.length; i++) {
            this.payments[i] = new Payment(f.payments[i]);
        }
        this.date = new Date(f.getDay(), f.getMonth(), f.getYear());
        this.author = f.getAuthor();
    }

    public FinanceReport(FinanceReport f,  Payment... payments) {
        this.quantityOfReports = payments.length;
        this.payments = new Payment[payments.length];
        for (int i = 0; i < payments.length; i++) {
            this.payments[i] = new Payment(payments[i]);
        }
        this.date = new Date(f.getDay(), f.getMonth(), f.getYear());
        this.author = f.getAuthor();
    }

//    public FinanceReport(int quantityOfReports) {
//        this.quantityOfReports = quantityOfReports;
//        this.payments = new Payment[quantityOfReports];
//        this.date = new Date();
//        this.author = "noname";
//    }


    //getters,setters
    public Payment getPayment(int i) {
        return payments[i];
    }

    public void setPayment(Payment report, int i) {
        this.payments[i] = new Payment(report);
    }

    public int getQuantityOfReports() {
        return payments.length;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public int getDay() {
        return this.date.getDay();
    }

    public void setDay(int day) {
        this.date.setDay(day);
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public void setMonth(int month) {
        this.date.setMonth(month);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public void setYear(int year) {
        this.date.setYear(year);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        String result = String.format("Автор: %s, Дата: %02d.%02d.%04d, Количество платежей: %s, Платежи:\n",
                author, getDay(), getMonth(), getYear(), quantityOfReports);
        if (payments != null) {
            for (Payment payment : payments) {
                if (payment != null) {
                    result = result + payment.toString();
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceReport)) return false;
        FinanceReport that = (FinanceReport) o;
        return getQuantityOfReports() == that.getQuantityOfReports() &&
                getAuthor().equals(that.getAuthor()) &&
                date.equals(that.date) &&
                Arrays.equals(getPayments(), that.getPayments());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getAuthor(), date, getQuantityOfReports());
        result = 31 * result + Arrays.hashCode(getPayments());
        return result;
    }
}