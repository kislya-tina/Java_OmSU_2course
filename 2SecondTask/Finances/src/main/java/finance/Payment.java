package finance;

import java.util.Objects;

public class Payment {
    //поля
    private String fullName;
    private Date date;
    private int amountOfPayment;

    //конструктор
    public Payment(String fullName,int day, int month, int year, int amountOfPayment) {
        this.fullName = fullName;
        if (amountOfPayment >= 0) {
            this.amountOfPayment = amountOfPayment;
        } else {
            throw new IllegalArgumentException("Некорректно введена сумма платежа");
        }
        this.date = new Date(day, month, year);
    }

    //конструктор по умолчанию
    public Payment() {
        this.fullName = "noname";
        this.date = new Date();
        this.amountOfPayment = 0;
    }

    //конструктор копирования
    public Payment(Payment p) {
        this.fullName = p.getFullName();
        this.date = new Date(p.getDay(), p.getMonth(), p.getYear());
        this.amountOfPayment = p.getAmountOfPayment();
    }

    // getters,setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return date.getDay();
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

    public Date getDate() {
        return this.date;
    }

    public void setDate(int day, int month, int year) {
        this.date = new Date(day, month, year);
    }


    public int getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(int amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return amountOfPayment == payment.amountOfPayment && Objects.equals(fullName, payment.fullName) && Objects.equals(date, payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, date, amountOfPayment);
    }

    @Override
    public String toString() {
        int rub = amountOfPayment / 100;
        int kop = amountOfPayment % 100;
        return String.format("Плательщик: %s, Дата: %02d.%02d.%04d, Сумма: %d руб. %02d коп.\n",
                fullName,
                getDay(),getMonth(),getYear(),
                rub, kop
        );
    }
}